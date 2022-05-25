package com.example.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hospital.service.OperationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OperationController {
	
	private final OperationService operationService;
	
	@Autowired
	public OperationController(OperationService operationService) {
		this.operationService = operationService;
	}
	
	@GetMapping("/operations")
	public String getAllOperations(Model model) {
		var operations = operationService.getAll();
		model.addAttribute("operations", operations);
		return "operation";
	}

}
