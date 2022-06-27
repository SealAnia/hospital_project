package com.example.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.model.entity.MedicalCard;
import com.example.hospital.model.repository.MedicalCardRepository;
import com.example.hospital.service.MedicalCardService;

@Service
public class MedicalCardServiceImpl implements MedicalCardService {
	
	private MedicalCardRepository medicalCardRepository;
	
	@Autowired
	public MedicalCardServiceImpl(MedicalCardRepository medicalCardRepository) {
		this.medicalCardRepository = medicalCardRepository;
	}

	@Override
	public List<MedicalCard> getAll() {
		return medicalCardRepository.findAll();
	}

	@Override
	public MedicalCard getById(Integer id) {
		return medicalCardRepository.getById(id);
	}

	@Override
	public MedicalCard createOrUpdate(MedicalCard medicalCard) {
		return medicalCardRepository.saveAndFlush(medicalCard);
	}

	@Override
	public void delete(MedicalCard medicalCard) {
		medicalCardRepository.delete(medicalCard);
	}

	@Override
	public List<MedicalCard> search(String keyword) {
		return null;
	}

}
