package com.example.hospital.dto;

import java.util.Date;
import java.util.List;

import com.example.hospital.model.entity.Department;
import com.example.hospital.model.entity.Medicine;

public class PatientDto {
	
	private String name;
	private String surname;
	private String diagnosis;
	private Date admission;
	private Date release;
	private String comments;
	
	private Department department;
	private Integer departmentid;
	
	private List<Medicine> medicines;
	
	private List<MedicineDto> medicineDtos;
	
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
	
	public Date getRelease() {
		return release;
	}
	public void setRelease(Date release) {
		this.release = release;
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
	
	public Integer getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}
	
	public List<Medicine> getMedicines() {
		return medicines;
	}
	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
	
	public List<MedicineDto> getMedicineDtos() {
		return medicineDtos;
	}
	public void setMedicineDtos(List<MedicineDto> medicineDtos) {
		this.medicineDtos = medicineDtos;
	}
	
}
