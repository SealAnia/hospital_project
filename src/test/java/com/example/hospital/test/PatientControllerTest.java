package com.example.hospital.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.hospital.model.entity.Patient;
import com.example.hospital.model.repository.PatientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource
class PatientControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
    public void getPatientById() throws Exception {
		this.patientRepository.getById(1);
		Patient patient = this.patientRepository.getById(1);
		assertThat(patient.getPatientid()).isEqualTo(1);
    }
	
	@Test
    public void getAllPatients() throws Exception {
        this.mockMvc.perform(get("/patients/page1").accept(MediaType.TEXT_PLAIN))
        .andExpect(status().isOk());
    }
	
}
