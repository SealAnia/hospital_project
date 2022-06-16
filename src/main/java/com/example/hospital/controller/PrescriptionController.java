package com.example.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hospital.dto.MedicineDto;
import com.example.hospital.dto.PatientDto;
import com.example.hospital.dto.PrescriptionDto;
import com.example.hospital.model.entity.Medicine;
import com.example.hospital.model.entity.Patient;
import com.example.hospital.model.entity.Prescription;
import com.example.hospital.service.MedicineService;
import com.example.hospital.service.PatientService;
import com.example.hospital.service.PrescriptionService;

@Controller
public class PrescriptionController {
	
	private final PrescriptionService prescriptionService;
	
	private final PatientService patientService;
	private final MedicineService medicineService;
	
	@Autowired
	public PrescriptionController(PrescriptionService prescriptionService,
			PatientService patientService, MedicineService medicineService) {
		this.prescriptionService = prescriptionService;
		this.patientService = patientService;
		this.medicineService = medicineService;
	}
	
	@GetMapping("/prescriptions")
	public String getAllPrescriptions(Model model) {
		var prescriptions = prescriptionService.getAll();
		model.addAttribute("prescriptions", prescriptions);
		return "prescription/prescriptions";
	}
	
	@GetMapping(value="/showprescriptionform")
	public String showCreatePrescription(Model model) {
		model.addAttribute("prescription", new PrescriptionDto());
		
		var patients = patientService.getAll();
		model.addAttribute("patients", patients);
		
		var medicines = medicineService.getAll();
		model.addAttribute("medicines", medicines);
		
	    return "prescription/create_prescription";
	}
	
	@PostMapping(value="/prescriptions")
	public String addWorker(@RequestParam(value = "patientid") Integer patientid, 
			@RequestParam(value = "medicineid") Integer medicineid, 
			@ModelAttribute("prescription") PrescriptionDto prescriptionDto,
			@ModelAttribute("patient") PatientDto patientDto, 
			@ModelAttribute("medicine") MedicineDto medicineDto,
			Model model) {
		var prescription = new Prescription();
		
		var patient = new Patient();
		patient = patientService.getById(patientid);
		prescription.setPatient(patient);
		
		var medicine = new Medicine();
		medicine = medicineService.getById(medicineid);
		prescription.setMedicine(medicine);
		
		prescriptionService.createOrUpdate(prescription);
		
		var prescriptions = prescriptionService.getAll();
		model.addAttribute("prescriptions", prescriptions);
		return "prescription/prescriptions";
	}

}
