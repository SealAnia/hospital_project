package com.example.hospital.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.example.hospital.dto.PatientDto;
import com.example.hospital.dto.ProcedureDto;
import com.example.hospital.model.entity.MedicalCard;
import com.example.hospital.model.entity.Patient;
import com.example.hospital.model.entity.Procedure;
import com.example.hospital.model.repository.ProcedureRepository;
import com.example.hospital.service.MedicalCardService;
import com.example.hospital.service.PatientService;
import com.example.hospital.service.ProcedureService;

@Controller
public class ProcedureController {
	
	private final ProcedureService procedureService;
	private final PatientService patientService;
	private final ProcedureRepository procedureRepository;
	private final MedicalCardService medicalCardService;

	@Autowired
	public ProcedureController(ProcedureService procedureService, 
			MedicalCardService medicalCardService,
			PatientService patientService, ProcedureRepository procedureRepository) {
		this.procedureService = procedureService;
		this.patientService = patientService;
		this.procedureRepository = procedureRepository;
		this.medicalCardService = medicalCardService;
	}
	
	//READ
	@GetMapping(value = "/procedures")
	public String getAllProcedures(Model model) {
		var procedures = procedureService.getAll();
		model.addAttribute("procedures", procedures);
		return "procedure/procedures";
	}
	
	@GetMapping(value = "/procedures/{procedureid}")
	public String procedureDetails(@PathVariable Integer procedureid, Model model) {
		List<Procedure> procedures = new ArrayList<Procedure>();
		Procedure procedure = procedureService.getById(procedureid);
		procedures.add(procedure);
		model.addAttribute("procedures", procedures);
		return "procedure/procedures";
	}
	
	@GetMapping("/procedures/byname/{name}")
	public String procedureByName(@PathVariable String name, Model model) {
		List<Procedure> procedures = new ArrayList<>();
		procedures = procedureService.getProcedureByName(name);
		model.addAttribute("procedures", procedures);
		return "procedure/procedures";
	}
	
	@GetMapping("/procedures/bydate/{date}")
	public String procedureByDate(@PathVariable Date date, Model model) {
		List<Procedure> procedures = new ArrayList<>();
		procedures = procedureService.getProcedureByDate(date);
		model.addAttribute("procedures", procedures);
		return "procedure/procedures";
	}
	
	@GetMapping("/procedure")
	public String getProcedureInfo(@RequestParam(value = "procedureid") Integer procedureid, Model model) {
		var procedure = procedureService.getById(procedureid);
		model.addAttribute("procedure", procedure);
		return "procedure/procedure_details";
	}
	
	@GetMapping("/procedures/sortedbydatediaposon")
	public String getProceduresByDateDiaposon
	(@RequestParam Date dateFirst, @RequestParam Date dateSecond, Model model) {
		List<Procedure> procedures = procedureService.getByDateBetween(dateFirst, dateSecond);
		model.addAttribute("procedures", procedures);
		return "procedure/procedures";
	}
	
	//SORT
	@GetMapping("/procedures/sortedby/name/asc")
	public String sortProceduresByNameAsc(Model model) {
		//var procedures = procedureService.sortProcedureByNameAsc();
		var procedures = procedureRepository.findAll(Sort.by(Direction.ASC, "name"));
		model.addAttribute("procedures", procedures);
		return "procedure/procedures";
	}
	
	@GetMapping("/procedures/sortedby/name/desc")
	public String sortProceduresByNameDesc(Model model) {
		//var procedures = procedureService.sortProcedureByNameDesc();
		var procedures = procedureRepository.findAll(Sort.by(Direction.DESC, "name"));
		model.addAttribute("procedures", procedures);
		return "procedure/procedures";
	}
	
	@GetMapping("/procedures/sortedby/date/asc")
	public String sortProceduresByDateAsc(Model model) {
		//var procedures = procedureService.sortProcedureByDateAsc();
		var procedures = procedureRepository.findAll(Sort.by(Direction.ASC, "date"));
		model.addAttribute("procedures", procedures);
		return "procedure/procedures";
	}
	
	@GetMapping("/procedures/sortedby/date/desc")
	public String sortProceduresByDateDesc(Model model) {
		//var procedures = procedureService.sortProcedureByDateDesc();
		var procedures = procedureRepository.findAll(Sort.by(Direction.DESC, "date"));
		model.addAttribute("procedures", procedures);
		return "procedure/procedures";
	}
	
	//CREATE 
	@GetMapping(value="/showprocedureform")
	public String showCreateProcedure(Model model) {
		model.addAttribute("procedure", new ProcedureDto());
		var patients = patientService.getAll();
		model.addAttribute("patients", patients);
		return "procedure/add_procedure";
	}
	
	@PostMapping(value="/procedures")
	public String addProcedure
	(@RequestParam(value = "patientid") Integer patientid,
			@ModelAttribute("procedure") ProcedureDto procedureDto, 
			@ModelAttribute("patient") PatientDto patientDto, 
			Model model) {
		var procedure = new Procedure();
		procedure.setName(procedureDto.getName());
		procedure.setDate(procedureDto.getDate());
		procedure.setDetails(procedureDto.getDetails());
		
		var patient = new Patient();
		patient = patientService.getById(patientid);
		procedure.setPatient(patient);
		
		var medicalCard = new MedicalCard();
		medicalCard.setProcedure(procedure);
		medicalCard.setPatient(patient);
		
		procedureService.createOrUpdate(procedure);
		
		medicalCardService.createOrUpdate(medicalCard);
		
		var procedures = procedureService.getAll();
		model.addAttribute("procedures", procedures);
		return "procedure/procedures";
	}
	
	//???
	//UPDATE
	@RequestMapping(value="/showeditprocedure/{procedureid}")
	public String showEditProcedure(@PathVariable("procedureid") Integer procedureid, 
			@ModelAttribute(name = "newProcedure") Procedure newProcedure, 
			Model model) {
		var procedure = procedureService.getById(procedureid);
		model.addAttribute("procedure", procedure);
		var patients = patientService.getAll();
		model.addAttribute("patients", patients);
		return "procedure/edit_procedure";
	}
	
	@PostMapping(value = "/edit_procedure") 
	public String editOperation(@ModelAttribute("procedure") ProcedureDto procedureDto, 
			@ModelAttribute("patient") PatientDto patientDto, 
			@RequestParam(value = "patientid") Integer patientid,
			Model model) {
		var procedure = procedureService.getById(procedureDto.getProcedureid());
		if(procedureDto.getName().length() <= 0) {
			procedure.setName(procedure.getName());
		} else procedure.setName(procedureDto.getName());
		if(procedureDto.getDate() == null) {
			procedure.setDate(procedure.getDate());
		} else procedure.setDate(procedureDto.getDate());
		if(procedureDto.getDetails().length() <= 0) {
			procedure.setDate(procedure.getDate());
		} else procedure.setDetails(procedureDto.getDetails());
		var patient = patientService.getById(patientid);
		procedure.setPatient(patient);
		procedureService.createOrUpdate(procedure);
		var procedures = procedureService.getAll();
		model.addAttribute("procedures", procedures);
		return "procedure/procedures";
	}
	
	//DELETE 
	@RequestMapping(value = "/deleteprocedure/{procedureid}", method = RequestMethod.GET)
	public String deleteProcedure(@PathVariable("procedureid") Integer procedureid) {
		var procedure = procedureService.getById(procedureid);
		procedureService.delete(procedure);
		return "procedure/delete_procedure";
	}
	
	//SEARCH
	@RequestMapping(value = "/procedures/searchresults")
	public String searchProcedureInfo(@RequestParam String keyword, Model model) {
		List<Procedure> results = procedureService.search(keyword);
		model.addAttribute("results", results);
		return "procedure/searchresults";
	}
	
}
