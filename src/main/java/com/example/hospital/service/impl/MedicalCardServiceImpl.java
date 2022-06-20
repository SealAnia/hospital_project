package com.example.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.model.entity.MedicalCard;
import com.example.hospital.model.repository.MedicalCardRepository;
import com.example.hospital.service.MedicalCardService;

@Service
public class MedicalCardServiceImpl implements MedicalCardService {
	
	@Autowired
	private MedicalCardRepository medicalCardRepository;

	@Override
	public List<MedicalCard> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedicalCard getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedicalCard createOrUpdate(MedicalCard medicalCard) {
		return medicalCardRepository.saveAndFlush(medicalCard);
	}

	@Override
	public void delete(MedicalCard entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MedicalCard> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
