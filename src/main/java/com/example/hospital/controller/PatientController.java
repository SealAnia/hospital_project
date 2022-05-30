package com.example.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.hospital.model.entity.Patient;
import com.example.hospital.service.PatientService;

@Controller
public class PatientController {
	
	private final PatientService patientService;
	
	@Autowired
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	//READ
	@GetMapping(value = "/patients")
	public String getAllPatients(Model model) {
		var patients = patientService.getAll();
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	@GetMapping(value = "/patients/{patientid}")
	public String getPatientInfo(@PathVariable Integer patientid, Model model) {
		List<Patient> patients = new ArrayList<Patient>();
		Patient patient = patientService.getById(patientid);
		patients.add(patient);
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}

}
