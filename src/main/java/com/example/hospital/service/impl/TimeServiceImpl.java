package com.example.hospital.service.impl;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.model.entity.Patient;
import com.example.hospital.service.PatientService;
import com.example.hospital.service.TimeService;

@Service
public class TimeServiceImpl implements TimeService {
	
	private final PatientService patientService;
	
	@Autowired
	public TimeServiceImpl(PatientService patientService) {
		this.patientService = patientService;
	}

	@Override
	public Long countTime(Integer patientid) {
		Patient patient = patientService.getById(patientid); 
		if(patient.getRelease() == null) {
			Date today = new Date();
			return TimeUnit.MILLISECONDS.toDays(today.getTime() - patient.getAdmission().getTime());
		}
		return TimeUnit.MILLISECONDS.toDays(patient.getRelease().getTime() - patient.getAdmission().getTime());
	}

}
