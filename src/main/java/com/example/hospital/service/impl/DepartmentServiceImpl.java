package com.example.hospital.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.model.entity.Department;
import com.example.hospital.model.entity.Patient;
import com.example.hospital.model.repository.DepartmentRepository;
import com.example.hospital.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentRepository departmentRepository;
	
	@Autowired
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	@Override
	public List<Department> getAll() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getById(Integer id) {
		return departmentRepository.getById(id);
	}

	@Override
	public Department createOrUpdate(Department department) {
		return departmentRepository.saveAndFlush(department);
	}
	
	@Override
	public void delete(Department department) {
		departmentRepository.delete(department);
	}

	@Override
	public List<Department> getDepartmentByName(String name) {
		return departmentRepository.getDepartmentByName(name);
	}
	
	@Override
	public List<Department> search(String keyword) {
		return departmentRepository.search(keyword);
	}
	
	@Override
	public int countPatientsOnTreatment(Integer id) {
		Department department = departmentRepository.getById(id);
		var patients = department.getPatients();
		int count = 0;
		for(Patient patient: patients) {
			if(patient.getRelease() == null) {
				count++;
			}
		}
		return count;
	}
	
}
