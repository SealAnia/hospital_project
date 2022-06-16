package com.example.hospital.dto;

import java.util.List;

import com.example.hospital.model.entity.Patient;

public class MedicineDto {
	
	private Integer id;
	private String name;
	private Double numberPerDay;
	
	private List<Patient> patients;
	private List<PatientDto> patientsDtos;
	
	private Integer patientid;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getNumberPerDay() {
		return numberPerDay;
	}
	public void setNumberPerDay(Double numberPerDay) {
		this.numberPerDay = numberPerDay;
	}
	
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	public Integer getPatientid() {
		return patientid;
	}
	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}
	public List<PatientDto> getPatientsDtos() {
		return patientsDtos;
	}
	public void setPatientsDtos(List<PatientDto> patientsDtos) {
		this.patientsDtos = patientsDtos;
	}
	
}
