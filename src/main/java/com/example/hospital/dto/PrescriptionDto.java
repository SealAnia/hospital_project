package com.example.hospital.dto;

import com.example.hospital.model.entity.Medicine;
import com.example.hospital.model.entity.Patient;

public class PrescriptionDto {
	
	private Patient patient;
	private Medicine medicine;
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

}
