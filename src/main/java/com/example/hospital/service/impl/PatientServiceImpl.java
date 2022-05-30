package com.example.hospital.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void createOrUpdate(Patient patient) {
		patientRepository.saveAndFlush(patient);
	}

	@Override
	public void delete(Integer id) {
		patientRepository.deleteById(id);
	}

	@Override
	public void delete(Patient patient) {
		patientRepository.delete(patient);
	}

	@Override
	public List<Patient> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//public List<Patient> getByDeptId(Integer departmentid) {
		//return patientRepository.findBy(null, null)
	//}
	
}
