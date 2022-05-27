package com.example.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.hospital.model.entity.Medicine;
import com.example.hospital.service.MedicineService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
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
		return "medicine_views/medicines";
	}
	
	@GetMapping(value = "/medicines/{id}")
	public String medicineDetails(@PathVariable Integer id, Model model) {
		List<Medicine> medicines = new ArrayList<Medicine>();
		Medicine medicine = medicineService.getById(id);
		medicines.add(medicine);
		model.addAttribute("medicines", medicines);
		return "medicine_views/medicines";
	}

}
