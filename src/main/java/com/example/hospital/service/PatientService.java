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
	
	Iterable<Patient> sortPatientsByNameAsc();
	Iterable<Patient> sortPatientsByNameDesc();
	Iterable<Patient> sortPatientsBySurnameAsc();
	Iterable<Patient> sortPatientsBySurnameDesc();
	Iterable<Patient> sortPatientsByDiagnosisAsc();
	Iterable<Patient> sortPatientsByDiagnosisDesc();
	Iterable<Patient> sortPatientsByAdmissionAsc();
	Iterable<Patient> sortPatientsByAdmissionDesc();
	Iterable<Patient> sortPatientsByReleaseAsc();
	Iterable<Patient> sortPatientsByReleaseDesc();
	
}
