package com.example.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping(value = "/medicines")
	public String getAllMedicines(Model model) {
		var medicines = medicineService.getAll();
		model.addAttribute("medicines", medicines);
		return "medicine";
	}

}
