package com.example.hospital.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hospital.dto.OperationDto;
import com.example.hospital.dto.PatientDto;
import com.example.hospital.model.entity.Operation;
import com.example.hospital.model.entity.Patient;
import com.example.hospital.service.OperationService;
import com.example.hospital.service.PatientService;

@Controller
public class OperationController {
	
	private final OperationService operationService;
	
	private final PatientService patientService;
	
	@Autowired
	public OperationController(OperationService operationService, 
			PatientService patientService) {
		this.operationService = operationService;
		this.patientService = patientService;
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
	
	@GetMapping("/operations/bydate/{date}")
	public String operationByName(@PathVariable Date date, Model model) {
		List<Operation> operations = new ArrayList<>();
		operations = operationService.getOperationByDate(date);
		model.addAttribute("operations", operations);
		return "operation_views/operations";
	}
	
	@GetMapping("/operation")
	public String getOperationInfo(@RequestParam(value = "id") Integer id, Model model) {
		var operation = operationService.getById(id);
		model.addAttribute("operation", operation);
		return "operation_views/operation_details";
	}
	
	@GetMapping("/operations/sortedbydatediaposon")
	public String getOperationsByDateDiaposon
	(@RequestParam Date dateFirst, @RequestParam Date dateSecond, Model model) {
		List<Operation> operations = operationService.getByDateBetween(dateFirst, dateSecond);
		model.addAttribute("operations", operations);
		return "operation_views/operations";
	}
	
	//SORT
	@GetMapping("/operations/sortedby/date/asc")
	public String sortOperationsByDateAsc(Model model) {
		var operations = operationService.sortOperationsByDateAsc();
		model.addAttribute("operations", operations);
		return "operation_views/operations";
	}
	
	@GetMapping("/operations/sortedby/date/desc")
	public String sortOperationsByDateDesc(Model model) {
		var operations = operationService.sortOperationsByDateDesc();
		model.addAttribute("operations", operations);
		return "operation_views/operations";
	}
	
	//CREATE
	@GetMapping(value="/showoperationform")
	public String showCreateOperation(Model model) {
		model.addAttribute("operation", new OperationDto());
		return "operation_views/add_operation";
	}
	
	@PostMapping(value="/operations")
	public String addOperation
	(@RequestParam(value = "patientid") Integer patientid,
			@ModelAttribute("operation") OperationDto operationDto, 
			@ModelAttribute("patient") PatientDto patientDto, 
			Model model) {
		var operation = new Operation();
		operation.setDate(operationDto.getDate());
		operation.setComments(operationDto.getComments());
		var patient = new Patient();
		patient = patientService.getById(patientid);
		operation.setPatient(patient);
		operationService.createOrUpdate(operation);
		var operations = operationService.getAll();
		model.addAttribute("operations", operations);
		return "operation_views/operations";
	}
	
	//???
	//UPDATE
	@RequestMapping(value="/showeditoperation/{id}")
	public String showEditOperation(@PathVariable("id") Integer id, Model model) {
		var operation = operationService.getById(id);
		model.addAttribute("operation", operation);
		return "operation_views/edit_operation";
	}
	
	//DELETE
	@RequestMapping(value = "/deleteoperation/{id}", method = RequestMethod.GET)
	public String deleteOperation(@PathVariable("id") Integer id) {
		var operation = operationService.getById(id);
		operationService.delete(operation);
		return "operation_views/delete_operation";
	}
	
	//SEARCH
	@RequestMapping(value = "/operations/searchresults")
	public String searchOperationInfo(@RequestParam String keyword, Model model) {
		List<Operation> results = operationService.search(keyword);
		model.addAttribute("results", results);
		return "operation_views/searchresults";
	}

}
