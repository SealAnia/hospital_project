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

import com.example.hospital.dto.ProcedureDto;
import com.example.hospital.model.entity.Procedure;
import com.example.hospital.service.ProcedureService;

@Controller
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
		model.addAttribute("procedures", procedures);
		return "procedure_views/procedures";
	}
	
	@GetMapping("/procedures/byname/{name}")
	public String procedureByName(@PathVariable String name, Model model) {
		List<Procedure> procedures = new ArrayList<>();
		procedures = procedureService.getProcedureByName(name);
		model.addAttribute("procedures", procedures);
		return "procedure_views/procedures";
	}
	
	@GetMapping("/procedures/bydate/{date}")
	public String procedureByDate(@PathVariable Date date, Model model) {
		List<Procedure> procedures = new ArrayList<>();
		procedures = procedureService.getProcedureByDate(date);
		model.addAttribute("procedures", procedures);
		return "procedure_views/procedures";
	}
	
	@GetMapping("/procedure")
	public String getProcedureInfo(@RequestParam(value = "procedureid") Integer procedureid, Model model) {
		var procedure = procedureService.getById(procedureid);
		model.addAttribute("procedure", procedure);
		return "procedure_views/procedure_details";
	}
	
	//SORT
	@GetMapping("/procedures/sortedby/name/asc")
	public String sortProceduresByNameAsc(Model model) {
		var procedures = procedureService.sortProcedureByNameAsc();
		model.addAttribute("procedures", procedures);
		return "procedure_views/procedures";
	}
	
	@GetMapping("/procedures/sortedby/name/desc")
	public String sortProceduresByNameDesc(Model model) {
		var procedures = procedureService.sortProcedureByNameDesc();
		model.addAttribute("procedures", procedures);
		return "procedure_views/procedures";
	}
	
	@GetMapping("/procedures/sortedby/date/asc")
	public String sortProceduresByDateAsc(Model model) {
		var procedures = procedureService.sortProcedureByDateAsc();
		model.addAttribute("procedures", procedures);
		return "procedure_views/procedures";
	}
	
	@GetMapping("/procedures/sortedby/date/desc")
	public String sortProceduresByDateDesc(Model model) {
		var procedures = procedureService.sortProcedureByDateDesc();
		model.addAttribute("procedures", procedures);
		return "procedure_views/procedures";
	}
	
	//CREATE 
	@GetMapping(value="/showprocedureform")
	public String showCreateProcedure(Model model) {
		model.addAttribute("procedure", new ProcedureDto());
		return "procedure_views/add_procedure";
	}
	
	@PostMapping(value="/procedures")
	public String addProcedure
	(@ModelAttribute("procedure") ProcedureDto procedureDto, Model model) {
		var procedure = new Procedure();
		procedure.setName(procedureDto.getName());
		procedure.setDate(procedureDto.getDate());
		procedure.setDetails(procedureDto.getDetails());
		procedureService.createOrUpdate(procedure);
		var procedures = procedureService.getAll();
		model.addAttribute("procedures", procedures);
		return "procedure_views/procedures";
	}
	
	//UPDATE
	
	//DELETE 
	@RequestMapping(value = "/deleteprocedure/{procedureid}", method = RequestMethod.GET)
	public String deleteProcedure(@PathVariable("procedureid") Integer procedureid) {
		var procedure = procedureService.getById(procedureid);
		procedureService.delete(procedure);
		return "procedure_views/delete_procedure";
	}
	
	//SEARCH
	@RequestMapping(value = "/procedures/searchresults")
	public String searchProcedureInfo(@RequestParam String keyword, Model model) {
		List<Procedure> results = procedureService.search(keyword);
		model.addAttribute("results", results);
		return "procedure_views/searchresults";
	}
	
}
