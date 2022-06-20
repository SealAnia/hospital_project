package com.example.hospital.service;

import java.util.Date;
import java.util.List;

import com.example.hospital.model.entity.Patient;

public interface PatientService extends DefaultService<Patient> {
	
	List<Patient> getPatientByName(String name);
	List<Patient> getPatientBySurname(String surname);
	List<Patient> getPatientByDiagnosis(String diagnosis);
	List<Patient> getPatientByAdmission(Date admission);
	List<Patient> getPatientByRelease(Date release);
	List<Patient> getByNameAndSurname(String name, String surname);
	
}
