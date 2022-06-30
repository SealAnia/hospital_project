package com.example.hospital.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.model.entity.Patient;
import com.example.hospital.model.repository.PatientRepository;
import com.example.hospital.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	private PatientRepository patientRepository;
	
	@Autowired
	public PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
	public List<Patient> getAll() {
		return patientRepository.findAll();
	}

	@Override
	public Patient getById(Integer id) {
		return patientRepository.getById(id);
	}
	
	@Override
	public Patient createOrUpdate(Patient patient) {
		return patientRepository.saveAndFlush(patient);
	}
	
	@Override
	public void delete(Patient patient) {
		patientRepository.delete(patient);
	}

	@Override
	public List<Patient> search(String keyword) {
		return patientRepository.search(keyword);
	}

	@Override
	public List<Patient> getPatientByName(String name) {
		return patientRepository.getPatientByName(name);
	}

	@Override
	public List<Patient> getPatientBySurname(String surname) {
		return patientRepository.getPatientBySurname(surname);
	}

	@Override
	public List<Patient> getPatientByDiagnosis(String diagnosis) {
		return patientRepository.getPatientByDiagnosis(diagnosis);
	}

	@Override
	public List<Patient> getPatientByAdmission(Date admission) {
		return patientRepository.getPatientByAdmission(admission);
	}

	@Override
	public List<Patient> getPatientByRelease(Date release) {
		return patientRepository.getPatientByRelease(release);
	}
	
	@Override
	public List<Patient> getByNameAndSurname(String name, String surname) {
		return patientRepository.getByNameAndSurname(name, surname);
	}
	
}
