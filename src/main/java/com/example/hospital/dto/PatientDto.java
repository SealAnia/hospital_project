package com.example.hospital.dto;

import java.util.Date;
import java.util.List;

import com.example.hospital.model.entity.Department;
import com.example.hospital.model.entity.Medicine;
import com.example.hospital.model.entity.Operation;
import com.example.hospital.model.entity.Procedure;

public class PatientDto {
	
	private Integer patientId;
	private String name;
	private String surname;
	private String diagnosis;
	private Date admission;
	private Date release;
	private String comments;
	private Long days;
	private Department department;
	private Integer departmentid;
	private String result;
	
	private List<Medicine> medicines;
	private List<Operation> operations;
	private List<Procedure> procedures;
	
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
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
	
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	public List<Procedure> getProcedures() {
		return procedures;
	}
	public void setProcedures(List<Procedure> procedures) {
		this.procedures = procedures;
	}
	
	public Long getDays() {
		return days;
	}
	public void setDays(Long days) {
		this.days = days;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
