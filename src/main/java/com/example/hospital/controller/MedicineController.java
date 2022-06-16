package com.example.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hospital.dto.MedicineDto;
import com.example.hospital.model.entity.Medicine;
import com.example.hospital.service.MedicineService;

@Controller
public class MedicineController {
	
	private final MedicineService medicineService;
	
	@Autowired
	public MedicineController(MedicineService medicineService) {
		this.medicineService = medicineService;
	}
	
	//READ
	@GetMapping(value = "/medicines")
	public String getAllMedicines(Model model) {
		var medicines = medicineService.getAll();
		model.addAttribute("medicines", medicines);
		return "medicine/medicines";
	}
	
	@GetMapping(value = "/medicines/{id}")
	public String medicineDetails(@PathVariable Integer id, Model model) {
		List<Medicine> medicines = new ArrayList<Medicine>();
		Medicine medicine = medicineService.getById(id);
		medicines.add(medicine);
		model.addAttribute("medicines", medicines);
		return "medicine/medicines";
	}
	
	@GetMapping(value = "/medicines/byname/{name}")
	public String medicineByName(@PathVariable String name, Model model) {
		List<Medicine> medicines = new ArrayList<>();
		medicines = medicineService.getMedicineByName(name);
		model.addAttribute("medicines", medicines);
		return "medicine/medicines";
	}
	
	//SORT
	@GetMapping("/medicines/sorted/byname/asc")
	public String sortMedicinesByNameAsc(Model model) {
		var medicines = medicineService.sortMedicinesByNameAsc();
		model.addAttribute("medicines", medicines);
		return "medicine/medicines";
	}
	
	@GetMapping("/medicines/sorted/byname/desc")
	public String sortMedicinesByNameDesc(Model model) {
		var medicines = medicineService.sortMedicinesByNameDesc();
		model.addAttribute("medicines", medicines);
		return "medicine/medicines";
	}
	
	//CREATE
	@GetMapping(value="/showmedicineform")
	public String showCreateMedicine(Model model) {
		model.addAttribute("medicine", new MedicineDto());
		return "medicine/add_medicine";
	}
	
	@PostMapping(value="/medicines")
	public String addMedicine
	(@ModelAttribute("medicine") MedicineDto medicineDto, 
			Model model) {
		var medicine = new Medicine();
		medicine.setName(medicineDto.getName());
		medicine.setNumberPerDay(medicineDto.getNumberPerDay());
		
		medicineService.createOrUpdate(medicine);
		var medicines = medicineService.getAll();
		model.addAttribute("medicines", medicines);
		return "medicine/medicines";
	}
	
	//???
	//UPDATE
	@RequestMapping(value="/showeditmedicine/{id}")
	public String showEditMedicine(@PathVariable("id") Integer id, Model model) {
		var medicine = medicineService.getById(id);
		model.addAttribute("medicine", medicine);
		return "medicine/edit_medicine";
	}
	
	@PutMapping(value="/medicines/{id}")
	public String editMedicine
	(@PathVariable("id") Integer id, @RequestBody Medicine newMedicine, Model model) {
		var medicine = medicineService.getById(id);
		//model.addAttribute("department", department);
		medicine.setName(newMedicine.getName());
		medicine.setNumberPerDay(newMedicine.getNumberPerDay());
		newMedicine = medicineService.createOrUpdate(medicine);
		//model.addAttribute("department", department);
		var medicines = medicineService.getAll();
		model.addAttribute("medicines", medicines);
		return "medicine/medicines";
	}
	
	//DELETE
	@RequestMapping(value = "/deletemedicine/{id}", method = RequestMethod.GET)
	public String deleteMedicine(@PathVariable("id") Integer id) {
		var medicine = medicineService.getById(id);
		medicineService.delete(medicine);
		return "medicine/delete_medicine";
	}
	
	//SEARCH
	@RequestMapping(value = "/medicines/searchresults")
	public String searchMedicineInfo(@RequestParam String keyword, Model model) {
		List<Medicine> results = medicineService.search(keyword);
		model.addAttribute("results", results);
		return "medicine/searchresults";
	}
	
}
