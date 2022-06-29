package com.example.hospital.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import com.example.hospital.model.entity.Department;
import com.example.hospital.model.entity.Patient;
import com.example.hospital.model.repository.PatientRepository;
import com.example.hospital.service.impl.PatientServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class PatientServiceImplTest {
	
	@Mock
	private PatientRepository patientRepository;
	
	private PatientServiceImpl patientService;
	
	private static Patient testPatient; 
	
	@BeforeClass
	public static void prepareTest() {
		testPatient.setName("name");
		testPatient.setSurname("surname");
		testPatient.setDiagnosis("diagnosis");
		testPatient.setAdmission(new Date());
		testPatient.setComments("comments");
		testPatient.setDepartment(new Department());
	}
	
	@Before
	public void init() {
		patientService = new PatientServiceImpl(patientRepository);
	}
	
	@Test
	public void updateTest() {
		when(patientRepository.findById(any(Integer.class))).then((Answer<?>) testPatient);
		when(patientRepository.saveAndFlush(any(Patient.class))).then((Answer<?>) patientRepository.getById(testPatient.getPatientid()));
		Patient patientForUpdate = patientRepository.getById(testPatient.getPatientid());
		
		patientForUpdate.setName("name2");
		patientForUpdate.setSurname("surname2");
		Patient resultPatient = patientService.createOrUpdate(patientForUpdate);
		
		assertNotNull(resultPatient);
		assertSame(resultPatient.getPatientid(), testPatient.getPatientid());
		assertTrue(resultPatient.getName().equals(patientForUpdate.getName()));
		assertTrue(resultPatient.getSurname().equals(patientForUpdate.getSurname()));
		assertEquals(resultPatient.getDiagnosis(),testPatient.getDiagnosis());
	}
	
}
