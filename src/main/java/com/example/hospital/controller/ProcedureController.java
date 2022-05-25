package com.example.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hospital.service.ProcedureService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProcedureController {
	
	private final ProcedureService procedureService;

	@Autowired
	public ProcedureController(ProcedureService procedureService) {
		this.procedureService = procedureService;
	}
	
	@GetMapping(value = "/procedures")
	public String getAllProcedures(Model model) {
		var procedures = procedureService.getAll();
		model.addAttribute("procedures", procedures);
		return "procedure";
	}
}
