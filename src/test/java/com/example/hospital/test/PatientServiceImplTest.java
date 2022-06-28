package com.example.hospital.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.hospital.model.entity.Department;
import com.example.hospital.model.entity.Patient;
import com.example.hospital.model.repository.PatientRepository;
import com.example.hospital.service.PatientService;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientServiceImplTest {
	
	@TestConfiguration
    static class PatientServiceImplTestContextConfiguration {
        @Bean
        public PatientService patientService() {
            return new PatientService() {

				@Override
				public List<Patient> getAll() {
					return null;
				}

				@Override
				public Patient getById(Integer id) {
					return null;
				}

				@Override
				public Patient createOrUpdate(Patient entity) {
					return null;
				}

				@Override
				public void delete(Patient entity) {
				}

				@Override
				public List<Patient> search(String keyword) {
					return null;
				}

				@Override
				public List<Patient> getPatientByName(String name) {
					return null;
				}

				@Override
				public List<Patient> getPatientBySurname(String surname) {
					return null;
				}

				@Override
				public List<Patient> getPatientByDiagnosis(String diagnosis) {
					return null;
				}

				@Override
				public List<Patient> getPatientByAdmission(Date admission) {
					return null;
				}

				@Override
				public List<Patient> getPatientByRelease(Date release) {
					return null;
				}

				@Override
				public List<Patient> getByNameAndSurname(String name, String surname) {
					return null;
				}
            };
        }
    }
	
	@Autowired
	private PatientService patientService;
	
	@MockBean
	private PatientRepository patientRepository;
	
	@Before
	void setUp() throws Exception {
		List<Patient> patients = new ArrayList<>();
		Patient patient = new Patient("name", "surname", "diagnosis", 
				new Date(), "comments", new Department());
		patients.add(patient);
		
		Mockito.when(patientRepository.getPatientByName(patient.getName()))
		.thenReturn(patients);
		
		Mockito.when(patientRepository.getPatientBySurname(patient.getSurname()))
		.thenReturn(patients);
		
		Mockito.when(patientRepository.getPatientByDiagnosis(patient.getDiagnosis()))
		.thenReturn(patients);
		
		Mockito.when(patientRepository.getPatientByAdmission(patient.getAdmission()))
		.thenReturn(patients);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
