package com.example.hospital.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hospital.dto.DepartmentDto;
import com.example.hospital.dto.PatientDto;
import com.example.hospital.model.entity.Department;
import com.example.hospital.model.entity.Patient;
import com.example.hospital.model.repository.PatientRepository;
import com.example.hospital.service.DepartmentService;
import com.example.hospital.service.PatientService;
import com.example.hospital.service.TimeService;

@Controller
public class PatientController {
	
	private final PatientService patientService;
	private final DepartmentService departmentService;
	private final TimeService timeService;
	private final PatientRepository patientRepository;
	
	@Autowired
	public PatientController(PatientService patientService, 
			PatientRepository patientRepository,
			DepartmentService departmentService, 
			TimeService timeService) {
		this.patientService = patientService;
		this.departmentService = departmentService;
		this.timeService = timeService;
		this.patientRepository = patientRepository;
	}
	
	//READ
	@GetMapping(value = "/patients/page{number}")
	public String getAllPatients(@PathVariable Integer number, Model model) {
		Page<Patient> patients = 
				patientRepository.findAll(PageRequest.of(number - 1, 5));
		model.addAttribute("number", number);
		model.addAttribute("patients", patients.getContent());
		return "patient/patients";
	}
	
	@GetMapping("/patients/expand")
	public String getAllPatients(Model model) {
		var patients = patientService.getAll();
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patients/{patientid}")
	public String getPatientById(@PathVariable Integer patientid, Model model) {
		List<Patient> patients = new ArrayList<Patient>();
		Patient patient = patientService.getById(patientid);
		patients.add(patient);
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patients/byname/{name}")
	public String patientByName(@PathVariable String name, Model model) {
		var patients = patientService.getPatientByName(name);
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patients/bysurname/{surname}")
	public String patientBySurname(@PathVariable String surname, Model model) {
		var patients = patientService.getPatientBySurname(surname);
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patients/bydiagnosis/{diagnosis}")
	public String patientByDiagnosis(@PathVariable String diagnosis, Model model) {
		var patients = patientService.getPatientByDiagnosis(diagnosis);
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patients/byadmission/{admission}")
	public String patientByAdmission(@PathVariable Date admission, Model model) {
		var patients = patientService.getPatientByAdmission(admission);
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patients/byrelease/{release}")
	public String patientByRelease(@PathVariable Date release, Model model) {
		var patients = patientService.getPatientByRelease(release);
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patient")
	public String getPatientInfo(@RequestParam(value = "patientid") Integer patientid, 
			@ModelAttribute("patient") PatientDto patientDto,
			Model model) {
		var patient = patientService.getById(patientid);
		patientDto.setDays(timeService.countTime(patientid));
		model.addAttribute("patient", patient);
		model.addAttribute("patientDto", patientDto);
		return "patient/patient_info";
	}
	
	@GetMapping("/patients/bynamesurname")
	public String getPatientsByNameAndSurname
	(@RequestParam String name, @RequestParam String surname, Model model) {
		var patients = patientService.getByNameAndSurname(name, surname);
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	//SORT
	@GetMapping(value = "/patients/sortedby/surname/asc")
	public String sortPatientsBySurnameAsc(Model model) {
		var patients = patientRepository.findAll(Sort.by(Direction.ASC, "surname"));
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/surname/desc")
	public String sortPatientsBySurnameDesc(Model model) {
		var patients = patientRepository.findAll(Sort.by(Direction.DESC, "surname"));
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/name/asc")
	public String sortPatientsByNameAsc(Model model) {
		var patients = patientRepository.findAll(Sort.by(Direction.ASC, "name"));
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/name/desc")
	public String sortPatientsByNameDesc(Model model) {
		var patients = patientRepository.findAll(Sort.by(Direction.DESC, "name"));
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/diagnosis/asc")
	public String sortPatientsByDiagnosisAsc(Model model) {
		var patients = patientRepository.findAll(Sort.by(Direction.ASC, "diagnosis"));
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/diagnosis/desc")
	public String sortPatientsByDiagnosisDesc(Model model) {
		var patients = patientRepository.findAll(Sort.by(Direction.DESC, "diagnosis"));
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/admission/asc")
	public String sortPatientsByAdmissionAsc(Model model) {
		var patients = patientRepository.findAll(Sort.by(Direction.ASC, "admission"));
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/admission/desc")
	public String sortPatientsByAdmissionDesc(Model model) {
		var patients = patientRepository.findAll(Sort.by(Direction.DESC, "admission"));
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/release/asc")
	public String sortPatientsByReleaseAsc(Model model) {
		var patients = patientRepository.findAll(Sort.by(Direction.ASC, "release"));
		model.addAttribute("patients", patients);
		return "patient/patients";
	}

	@GetMapping(value = "/patients/sortedby/release/desc")
	public String sortPatientsByReleaseDesc(Model model) {
		var patients = patientRepository.findAll(Sort.by(Direction.DESC, "release"));
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/department/asc")
	public String sortPatientsByDepartmentAsc(Model model) {
		var patients = patientRepository.findAll(Sort.by(Direction.ASC, "department.name"));
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	@GetMapping(value = "/patients/sortedby/department/desc")
	public String sortPatientsByDepartmentDesc(Model model) {
		var patients = patientRepository.findAll(Sort.by(Direction.DESC, "department.name"));
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	//CREATE
	@GetMapping(value="/showpatientform")
	public String showCreatePatient(Model model) {
		model.addAttribute("patient", new PatientDto());
		var departments = departmentService.getAll();
		model.addAttribute("departments", departments);
		return "patient/add_new_patient";	
	}
	
	@PostMapping(value="/patients/page1")
	public String addPatient
	(@RequestParam(value = "departmentid") Integer departmentid,
			@ModelAttribute("patient") PatientDto patientDto, 
			@ModelAttribute("department") DepartmentDto departmentDto, Model model) {
		var patient = new Patient();
		patient.setName(patientDto.getName());
		patient.setSurname(patientDto.getSurname());
		patient.setDiagnosis(patientDto.getDiagnosis());
		patient.setAdmission(patientDto.getAdmission());
		patient.setComments(patientDto.getComments());
		
		var department = new Department();
		department = departmentService.getById(departmentid);
		patient.setDepartment(department);
		
		patient.setComments(patientDto.getComments());
		patientService.createOrUpdate(patient);
		var patients = patientService.getAll();
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	//UPDATE
	@GetMapping(value="/showeditpatient/{patientid}")
	public String showEditPatient(@PathVariable("patientid") Integer patientid, 
			@ModelAttribute(name = "newPatient") Patient newPatient, 
			Model model) {
		var patient = patientService.getById(patientid);
		model.addAttribute("patient", patient);
		var departments = departmentService.getAll();
		model.addAttribute("departments", departments);
		return "patient/edit_patient";
	}
	
	@PostMapping(value = "/editpatient")
	public String editPatient
	(@ModelAttribute("patient") PatientDto patientDto,
			@ModelAttribute("department") DepartmentDto departmentDto, 
			@RequestParam(value = "departmentid") Integer departmentid, 
			Model model) {
		var patient = patientService.getById(patientDto.getPatientid());
		if(patientDto.getName().length() <= 0) {
			patient.setName(patient.getName());
		} else patient.setName(patientDto.getName());
		
		if(patientDto.getSurname().length() <= 0) {
			patient.setSurname(patient.getSurname());
		} else patient.setSurname(patientDto.getSurname());
		
		if(patientDto.getDiagnosis().length() <= 0) {
			patient.setDiagnosis(patient.getDiagnosis());
		} else patient.setDiagnosis(patientDto.getDiagnosis());
		
		if(patientDto.getAdmission() == null) {
			patient.setAdmission(patient.getAdmission());
		} else patient.setAdmission(patientDto.getAdmission());
		
		if(patientDto.getRelease() == null) {
			patient.setRelease(patient.getRelease());
		} else patient.setRelease(patientDto.getRelease());
		
		if(patientDto.getComments().length() <= 0) {
			patient.setComments(patient.getComments());
		} else patient.setComments(patientDto.getComments());
		
		var department = departmentService.getById(departmentid);
		patient.setDepartment(department);
		
		if(patientDto.getResult().length() <= 0) {
			patient.setResult(patient.getResult());
		} else patient.setResult(patientDto.getResult());
		
		patientService.createOrUpdate(patient);
		var patients = patientService.getAll();
		model.addAttribute("patients", patients);
		return "patient/patients";
	}
	
	//DELETE
	@GetMapping(value = "/deletepatientinfo/{patientid}")
	public String deletePatient(@PathVariable("patientid") Integer patientid) {
		var patient = patientService.getById(patientid);
		patientService.delete(patient);
		return "patient/delete_patient";
	}
	
	//SEARCH
	@GetMapping(value = "/patients/searchresults")
	public String searchPatientInfo(@RequestParam String keyword, Model model) {
		var results = patientService.search(keyword);
		model.addAttribute("results", results);
		return "patient/searchresults";
	}

}
