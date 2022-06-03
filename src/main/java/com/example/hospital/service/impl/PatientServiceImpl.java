package com.example.hospital.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.hospital.model.entity.Patient;
import com.example.hospital.model.repository.PatientRepository;
import com.example.hospital.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository patientRepository;

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
	public Iterable<Patient> sortPatientsByNameAsc() {
		return patientRepository.findAll(Sort.by(Direction.ASC, "name"));
	}

	@Override
	public Iterable<Patient> sortPatientsByNameDesc() {
		return patientRepository.findAll(Sort.by(Direction.DESC, "name"));
	}

	@Override
	public Iterable<Patient> sortPatientsBySurnameAsc() {
		return patientRepository.findAll(Sort.by(Direction.ASC, "surname"));
	}

	@Override
	public Iterable<Patient> sortPatientsBySurnameDesc() {
		return patientRepository.findAll(Sort.by(Direction.DESC, "surname"));
	}

	@Override
	public Iterable<Patient> sortPatientsByDiagnosisAsc() {
		return patientRepository.findAll(Sort.by(Direction.ASC, "diagnosis"));
	}

	@Override
	public Iterable<Patient> sortPatientsByDiagnosisDesc() {
		return patientRepository.findAll(Sort.by(Direction.DESC, "diagnosis"));
	}

	@Override
	public Iterable<Patient> sortPatientsByAdmissionAsc() {
		return patientRepository.findAll(Sort.by(Direction.ASC, "admission"));
	}

	@Override
	public Iterable<Patient> sortPatientsByAdmissionDesc() {
		return patientRepository.findAll(Sort.by(Direction.DESC, "admission"));
	}

	@Override
	public Iterable<Patient> sortPatientsByReleaseAsc() {
		return patientRepository.findAll(Sort.by(Direction.ASC, "release"));
	}

	@Override
	public Iterable<Patient> sortPatientsByReleaseDesc() {
		return patientRepository.findAll(Sort.by(Direction.DESC, "release"));
	}
	
	//public List<Patient> getByDeptId(Integer departmentid) {
		//return patientRepository.findBy(null, null)
	//}
	
}
