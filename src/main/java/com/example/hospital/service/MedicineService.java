package com.example.hospital.service;

import java.util.List;

import com.example.hospital.model.entity.Medicine;

public interface MedicineService extends DefaultService<Medicine> {
	
	List<Medicine> getMedicineByName(String name);
	
}
