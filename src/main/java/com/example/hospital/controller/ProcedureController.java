package com.example.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.hospital.model.entity.Procedure;
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
	
	//READ
	@GetMapping(value = "/procedures")
	public String getAllProcedures(Model model) {
		var procedures = procedureService.getAll();
		model.addAttribute("procedures", procedures);
		return "procedure_views/procedures";
	}
	
	@GetMapping(value = "/procedures/{procedureid}")
	public String procedureDetails(@PathVariable Integer procedureid, Model model) {
		List<Procedure> procedures = new ArrayList<Procedure>();
		Procedure procedure = procedureService.getById(procedureid);
		procedures.add(procedure);
		model.addAttribute("prodedures", procedures);
		return "procedure_views/procedures";
	}
	
}
