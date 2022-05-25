package com.example.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.model.entity.Medicine;
import com.example.hospital.model.repository.MedicineRepository;
import com.example.hospital.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {
	
	@Autowired
	private MedicineRepository medicineRepository;

	@Override
	public List<Medicine> getAll() {
		return medicineRepository.findAll();
	}

	@Override
	public Medicine getById(Integer id) {
		return medicineRepository.findById(id).orElse(new Medicine());
	}

	@Override
	public void createOrUpdate(Medicine medicine) {
		medicineRepository.saveAndFlush(medicine);
	}

	@Override
	public void delete(Integer id) {
		medicineRepository.deleteById(id);
	}

	@Override
	public void delete(Medicine medicine) {
		medicineRepository.delete(medicine);
	}

}
