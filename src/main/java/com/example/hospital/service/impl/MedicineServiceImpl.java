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
		return medicineRepository.getById(id);
	}

	@Override
	public Medicine createOrUpdate(Medicine medicine) {
		return medicineRepository.saveAndFlush(medicine);
	}
	
	@Override
	public void delete(Medicine medicine) {
		medicineRepository.delete(medicine);
	}

	@Override
	public List<Medicine> search(String keyword) {
		return medicineRepository.search(keyword);
	}

	@Override
	public List<Medicine> getMedicineByName(String name) {
		return medicineRepository.getMedicineByName(name);
	}
	
}
