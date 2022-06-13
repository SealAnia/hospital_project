package com.example.hospital.dto;

import java.util.Date;

import com.example.hospital.model.entity.Patient;

public class ProcedureDto {
	
	private Integer procedureid;
	private String name;
	private String details;
	private Date date;
	
	private Patient patient;
	private Integer patientid;
	
	public Integer getProcedureid() {
		return procedureid;
	}
	public void setProcedureid(Integer procedureid) {
		this.procedureid = procedureid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Integer getPatientid() {
		return patientid;
	}
	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

}
