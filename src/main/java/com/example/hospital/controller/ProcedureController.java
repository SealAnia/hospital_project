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

import com.example.hospital.dto.PatientDto;
import com.example.hospital.dto.ProcedureDto;
import com.example.hospital.model.entity.Patient;
import com.example.hospital.model.entity.Procedure;
import com.example.hospital.service.PatientService;
import com.example.hospital.service.ProcedureService;

@Controller
public class ProcedureController {
	
	private final ProcedureService procedureService;
	
	private final PatientService patientService;

	@Autowired
	public ProcedureController(ProcedureService procedureService, 
			PatientService patientService) {
		this.procedureService = procedureService;
		this.patientService = patientService;
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
		var procedures = procedureService.sortProcedureByNameAsc();
		model.addAttribute("procedures", procedures);
		return "procedure/procedures";
	}
	
	@GetMapping("/procedures/sortedby/name/desc")
	public String sortProceduresByNameDesc(Model model) {
		var procedures = procedureService.sortProcedureByNameDesc();
		model.addAttribute("procedures", procedures);
		return "procedure/procedures";
	}
	
	@GetMapping("/procedures/sortedby/date/asc")
	public String sortProceduresByDateAsc(Model model) {
		var procedures = procedureService.sortProcedureByDateAsc();
		model.addAttribute("procedures", procedures);
		return "procedure/procedures";
	}
	
	@GetMapping("/procedures/sortedby/date/desc")
	public String sortProceduresByDateDesc(Model model) {
		var procedures = procedureService.sortProcedureByDateDesc();
		model.addAttribute("procedures", procedures);
		return "procedure/procedures";
	}
	
	//CREATE 
	@GetMapping(value="/showprocedureform")
	public String showCreateProcedure(Model model) {
		model.addAttribute("procedure", new ProcedureDto());
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
		
		procedureService.createOrUpdate(procedure);
		
		var procedures = procedureService.getAll();
		model.addAttribute("procedures", procedures);
		return "procedure/procedures";
	}
	
	//???
	//UPDATE
	
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
