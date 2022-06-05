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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hospital.dto.DepartmentDto;
import com.example.hospital.dto.PatientDto;
import com.example.hospital.model.entity.Department;
import com.example.hospital.model.entity.Patient;
import com.example.hospital.service.DepartmentService;
import com.example.hospital.service.PatientService;

@Controller
public class PatientController {
	
	private final PatientService patientService;
	
	private final DepartmentService departmentService;
	
	@Autowired
	public PatientController(PatientService patientService, 
			DepartmentService departmentService) {
		this.patientService = patientService;
		
		this.departmentService = departmentService;
	}
	
	//READ
	@GetMapping(value = "/patients")
	public String getAllPatients(Model model) {
		var patients = patientService.getAll();
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	@GetMapping(value = "/patients/{patientid}")
	public String getPatientById(@PathVariable Integer patientid, Model model) {
		List<Patient> patients = new ArrayList<Patient>();
		Patient patient = patientService.getById(patientid);
		patients.add(patient);
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	@GetMapping(value = "/patients/byname/{name}")
	public String patientByName(@PathVariable String name, Model model) {
		List<Patient> patients = new ArrayList<>();
		patients = patientService.getPatientByName(name);
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	@GetMapping(value = "/patients/bysurname/{surname}")
	public String patientBySurname(@PathVariable String surname, Model model) {
		List<Patient> patients = new ArrayList<>();
		patients = patientService.getPatientBySurname(surname);
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	@GetMapping(value = "/patients/bydiagnosis/{diagnosis}")
	public String patientByDiagnosis(@PathVariable String diagnosis, Model model) {
		List<Patient> patients = new ArrayList<>();
		patients = patientService.getPatientByDiagnosis(diagnosis);
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	@GetMapping(value = "/patients/byadmission/{admission}")
	public String patientByAdmission(@PathVariable Date admission, Model model) {
		List<Patient> patients = new ArrayList<>();
		patients = patientService.getPatientByAdmission(admission);
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	@GetMapping(value = "/patients/byrelease/{release}")
	public String patientByRelease(@PathVariable Date release, Model model) {
		List<Patient> patients = new ArrayList<>();
		patients = patientService.getPatientByRelease(release);
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	@GetMapping(value = "/patient")
		public String getPatientInfo(@RequestParam(value = "id") Integer patientid, Model model) {
		var patient = patientService.getById(patientid);
		model.addAttribute("patient", patient);
		return "patient_views/patient_info";
	}
	
	//SORT
	@GetMapping(value = "/patients/sortedby/surname/asc")
	public String sortPatientsBySurnameAsc(Model model) {
		var patients = patientService.sortPatientsBySurnameAsc();
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/surname/desc")
	public String sortPatientsBySurnameDesc(Model model) {
		var patients = patientService.sortPatientsBySurnameDesc();
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/name/asc")
	public String sortPatientsByNameAsc(Model model) {
		var patients = patientService.sortPatientsByNameAsc();
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/name/desc")
	public String sortPatientsByNameDesc(Model model) {
		var patients = patientService.sortPatientsByNameDesc();
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/diagnosis/asc")
	public String sortPatientsByDiagnosisAsc(Model model) {
		var patients = patientService.sortPatientsByDiagnosisAsc();
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/diagnosis/desc")
	public String sortPatientsByDiagnosisDesc(Model model) {
		var patients = patientService.sortPatientsByDiagnosisDesc();
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/admission/asc")
	public String sortPatientsByAdmissionAsc(Model model) {
		var patients = patientService.sortPatientsByAdmissionAsc();
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/admission/desc")
	public String sortPatientsByAdmissionDesc(Model model) {
		var patients = patientService.sortPatientsByAdmissionDesc();
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/release/asc")
	public String sortPatientsByReleaseAsc(Model model) {
		var patients = patientService.sortPatientsByReleaseAsc();
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}

	@GetMapping(value = "/patients/sortedby/release/desc")
	public String sortPatientsByReleaseDesc(Model model) {
		var patients = patientService.sortPatientsByReleaseDesc();
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	//CREATE
	@GetMapping(value="/showpatientform")
	public String showCreatePatient(Model model) {
		model.addAttribute("patient", new PatientDto());
		return "patient_views/add_new_patient";	
	}
	
	@PostMapping(value="/patients")
	public String addPatient
	(@RequestParam(value = "departmentid") Integer departmentid,
			@ModelAttribute("patient") PatientDto patientDto, 
			@ModelAttribute("department") DepartmentDto departmentDto, Model model) {
		var patient = new Patient();
		patient.setName(patientDto.getName());
		patient.setSurname(patientDto.getSurname());
		patient.setDiagnosis(patientDto.getDiagnosis());
		patient.setAdmission(patientDto.getAdmission());
		
		var department = new Department();
		department = departmentService.getById(departmentid);
		
		patient.setDepartment(department);
		
		patient.setComments(patient.getComments());
		patientService.createOrUpdate(patient);
		var patients = patientService.getAll();
		model.addAttribute("patients", patients);
		return "patient_views/patients";
	}
	
	//UPDATE
	
	//DELETE
	
	//SEARCH
	@RequestMapping(value = "/patients/searchresults")
	public String searchPatientInfo(@RequestParam String keyword, Model model) {
		List<Patient> results = patientService.search(keyword);
		model.addAttribute("results", results);
		return "patient_views/searchresults";
	}

}
