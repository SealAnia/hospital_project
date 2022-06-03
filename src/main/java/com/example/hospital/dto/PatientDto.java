package com.example.hospital.dto;

import java.util.Date;

import com.example.hospital.model.entity.Department;

public class PatientDto {
	
	private String name;
	private String surname;
	private String diagnosis;
	private Date admission;
	private String comments;
	private Department department;
	//private Integer departmentid;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	public Date getAdmission() {
		return admission;
	}
	public void setAdmission(Date admission) {
		this.admission = admission;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
