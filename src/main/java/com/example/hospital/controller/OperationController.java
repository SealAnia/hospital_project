package com.example.hospital.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hospital.dto.OperationDto;
import com.example.hospital.dto.PatientDto;
import com.example.hospital.model.entity.MedicalCard;
import com.example.hospital.model.entity.Operation;
import com.example.hospital.model.entity.Patient;
import com.example.hospital.model.entity.User;
import com.example.hospital.model.repository.OperationRepository;
import com.example.hospital.service.MedicalCardService;
import com.example.hospital.service.OperationService;
import com.example.hospital.service.PatientService;
import com.example.hospital.service.impl.UserServiceImpl;

@Controller
public class OperationController {
	
	private final OperationService operationService;
	private final PatientService patientService;
	private final OperationRepository operationRepository;
	private final MedicalCardService medicalCardService;
	private final UserServiceImpl userService;
	
	@Autowired
	public OperationController(OperationService operationService, 
			MedicalCardService medicalCardService,
			UserServiceImpl userService,
			PatientService patientService, OperationRepository operationRepository) {
		this.operationService = operationService;
		this.patientService = patientService;
		this.operationRepository = operationRepository;
		this.medicalCardService = medicalCardService;
		this.userService = userService;
	}
	
	//READ
	@GetMapping("/operations")
	public String getAllOperations(Model model) {
		var operations = operationService.getAll();
		model.addAttribute("operations", operations);
		return "operation/operations";
	}
	
	@GetMapping("/operations/{id}")
	public String operationDetails(@PathVariable Integer id, Model model) {
		List<Operation> operations = new ArrayList<Operation>();
		Operation operation = operationService.getById(id);
		operations.add(operation);
		model.addAttribute("operations", operations);
		return "operation/operations";
	}
	
	@GetMapping("/operations/bydate/{date}")
	public String operationByName(@PathVariable Date date, Model model) {
		var operations = operationService.getOperationByDate(date);
		model.addAttribute("operations", operations);
		return "operation/operations";
	}
	
	@GetMapping("/operation")
	public String getOperationInfo(@RequestParam(value = "id") Integer id, Model model) {
		var operation = operationService.getById(id);
		model.addAttribute("operation", operation);
		return "operation/operation_details";
	}
	
	@GetMapping("/operations/sortedbydatediaposon")
	public String getOperationsByDateDiaposon
	(@RequestParam Date dateFirst, @RequestParam Date dateSecond, Model model) {
		var operations = operationService.getByDateBetween(dateFirst, dateSecond);
		model.addAttribute("operations", operations);
		return "operation/operations";
	}
	
	//SORT
	@GetMapping("/operations/sortedby/date/asc")
	public String sortOperationsByDateAsc(Model model) {
		var operations = operationRepository.findAll(Sort.by(Direction.ASC, "date"));
		model.addAttribute("operations", operations);
		return "operation/operations";
	}
	
	@GetMapping("/operations/sortedby/date/desc")
	public String sortOperationsByDateDesc(Model model) {
		var operations = operationRepository.findAll(Sort.by(Direction.DESC, "date"));
		model.addAttribute("operations", operations);
		return "operation/operations";
	}
	
	//CREATE
	@GetMapping(value="/showoperationform")
	public String showCreateOperation(Model model) {
		model.addAttribute("operation", new OperationDto());
		var patients = patientService.getAll();
		model.addAttribute("patients", patients);
		return "operation/add_operation";
	}
	
	@PostMapping(value="/operations")
	public String addOperation
	(@RequestParam(value = "patientid") Integer patientid,
			@ModelAttribute("operation") OperationDto operationDto, 
			@ModelAttribute("patient") PatientDto patientDto, 
			Authentication authentication, String username, 
			Model model) {
		var operation = new Operation();
		operation.setDate(operationDto.getDate());
		operation.setComments(operationDto.getComments());
		var patient = new Patient();
		patient = patientService.getById(patientid);
		operation.setPatient(patient);
		
		var medicalCard = new MedicalCard();
		medicalCard.setPatient(patient);
		medicalCard.setOperation(operation);
		
		username = authentication.getName();
		var worker = userService.loadUserByUsername(username);
		operation.setUser((User) worker);
		
		operationService.createOrUpdate(operation);
		
		medicalCardService.createOrUpdate(medicalCard);
		var operations = operationService.getAll();
		model.addAttribute("operations", operations);
		return "operation/operations";
	}
	
	//UPDATE
	@GetMapping(value="/showeditoperation/{id}")
	public String showEditOperation(@PathVariable("id") Integer id, 
			@ModelAttribute(name = "newOperation") Operation newOperation,
			Model model) {
		var operation = operationService.getById(id);
		model.addAttribute("operation", operation);
		var patients = patientService.getAll();
		model.addAttribute("patients", patients);
		return "operation/edit_operation";
	}
	
	@PostMapping(value = "/editoperation") 
	public String editOperation(@ModelAttribute("operation") OperationDto operationDto, 
			@ModelAttribute("patient") PatientDto patientDto,
			@RequestParam(value = "patientid") Integer patientid,
			Model model) {
		var operation = operationService.getById(operationDto.getId());
		if(operationDto.getDate() == null) {
			operation.setDate(operation.getDate());
		} else operation.setDate(operationDto.getDate());
		if(operationDto.getComments().length() <= 0) {
			operation.setComments(operationDto.getComments());
		} else operation.setComments(operationDto.getComments());
		
		var patient = patientService.getById(patientid);
		operation.setPatient(patient);
		
		operationService.createOrUpdate(operation);
		var operations = operationService.getAll();
		model.addAttribute("operations", operations);
		return "operation/operations";
	}
	
	//DELETE
	@GetMapping(value = "/deleteoperation/{id}")
	public String deleteOperation(@PathVariable("id") Integer id) {
		var operation = operationService.getById(id);
		operationService.delete(operation);
		return "operation/delete_operation";
	}
	
	//SEARCH
	@GetMapping(value = "/operations/searchresults")
	public String searchOperationInfo(@RequestParam String keyword, Model model) {
		var results = operationService.search(keyword);
		model.addAttribute("results", results);
		return "operation/searchresults";
	}

}
