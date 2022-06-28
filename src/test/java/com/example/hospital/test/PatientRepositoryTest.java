package com.example.hospital.test;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.example.hospital.config.AppConfiguration;
import com.example.hospital.model.entity.Department;
import com.example.hospital.model.entity.Patient;
import com.example.hospital.service.impl.DepartmentServiceImpl;
import com.example.hospital.service.impl.PatientServiceImpl;

@ContextConfiguration(classes = {AppConfiguration.class})
class PatientRepositoryTest {
	
	private final PatientServiceImpl patientService;
	
	private final DepartmentServiceImpl departmentService;
	
	@Autowired
	public PatientRepositoryTest(PatientServiceImpl patientService, 
			DepartmentServiceImpl departmentService) {
		super();
		this.patientService = patientService;
		this.departmentService = departmentService;
	}
	
	@Test
	public final void createOrUpdate(Patient patient) {
		final String name = "name";
		final String surname = "surname";
		final String diagnosis = "diagnosis";
		final Date admission = new Date();
		final String comments = "comments";
		final Department department = departmentService.getById(1);
		
		patient = new Patient(name, surname, diagnosis, admission, 
				comments, department);
		assert this.patientService != null;
		this.patientService.createOrUpdate(patient);
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
}
