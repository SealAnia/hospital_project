package com.example.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.model.entity.Prescription;
import com.example.hospital.model.repository.PrescriptionRepository;
import com.example.hospital.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Override
	public List<Prescription> getAll() {
		return prescriptionRepository.findAll();
	}

	@Override
	public Prescription getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prescription createOrUpdate(Prescription prescription) {
		return prescriptionRepository.saveAndFlush(prescription);
	}

	@Override
	public void delete(Prescription entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Prescription> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
