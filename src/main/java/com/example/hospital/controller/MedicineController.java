package com.example.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hospital.dto.MedicineDto;
import com.example.hospital.model.entity.Medicine;
import com.example.hospital.model.repository.MedicineRepository;
import com.example.hospital.service.MedicineService;

@Controller
public class MedicineController {
	
	private final MedicineService medicineService;
	private final MedicineRepository medicineRepository;
	
	@Autowired
	public MedicineController(MedicineService medicineService, MedicineRepository medicineRepository) {
		this.medicineService = medicineService;
		this.medicineRepository = medicineRepository;
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
	@GetMapping("/medicines/sortedby/name/asc")
	public String sortMedicinesByNameAsc(Model model) {
		var medicines = medicineRepository.findAll(Sort.by(Direction.ASC, "name"));
		model.addAttribute("medicines", medicines);
		return "medicine/medicines";
	}
	
	@GetMapping("/medicines/sortedby/name/desc")
	public String sortMedicinesByNameDesc(Model model) {
		var medicines = medicineRepository.findAll(Sort.by(Direction.DESC, "name"));
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
	@GetMapping(value="/showeditmedicine/{id}")
	public String showEditMedicine(@PathVariable("id") Integer id, 
			@ModelAttribute(name = "newMedicine") Medicine newMedicine,
			Model model) {
		var medicine = medicineService.getById(id);
		model.addAttribute("medicine", medicine);
		return "medicine/edit_medicine";
	}
	
	@PostMapping(value="/edit_medicine")
	public String editMedicine
	(@ModelAttribute("medicine") MedicineDto medicineDto, 
			Model model) {
		var medicine = medicineService.getById(medicineDto.getId());
		
		if(medicineDto.getName().length() <= 0) {
			medicine.setName(medicine.getName());
		} else {
			medicine.setName(medicineDto.getName());
		}
		
		if(medicineDto.getNumberPerDay() == null) {
			medicine.setNumberPerDay(medicine.getNumberPerDay());
		}else {
			medicine.setNumberPerDay(medicineDto.getNumberPerDay());
		}
		
		medicineService.createOrUpdate(medicine);
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
