package com.example.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.hospital.model.entity.Operation;
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
	
	//READ
	@GetMapping("/operations")
	public String getAllOperations(Model model) {
		var operations = operationService.getAll();
		model.addAttribute("operations", operations);
		return "operation_views/operations";
	}
	
	@GetMapping("/operations/{id}")
	public String operationDetails(@PathVariable Integer id, Model model) {
		List<Operation> operations = new ArrayList<Operation>();
		Operation operation = operationService.getById(id);
		operations.add(operation);
		model.addAttribute("operations", operations);
		return "operation_views/operations";
	}

}
