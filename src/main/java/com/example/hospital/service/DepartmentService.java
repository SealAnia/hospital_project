package com.example.hospital.service;

import java.util.List;

import com.example.hospital.model.entity.Department;

public interface DepartmentService extends DefaultService<Department> {
	
	List<Department> getDepartmentByName(String name);
	int countPatientsOnTreatment(Integer id);
	
}
