package com.example.hospital.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientid;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String diagnosis;
	@Column
	private Date admission;
	@Column(name = "releasedate")
	private Date release;
	@Column
	private String comments;
	@Column
	private String result;
	@ManyToOne
	@JoinColumn(name = "departmentid")
	private Department department;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Procedure> procedures;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Operation> operations;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Prescription> prescriptions;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<MedicalCard> medicalcards;
	
	public Patient() {
		
	}
	
	public Patient(String name, String surname, String diagnosis, Date admission, String comments,
			Department department) {
		this.name = name;
		this.surname = surname;
		this.diagnosis = diagnosis;
		this.admission = admission;
		this.comments = comments;
		this.department = department;
	}

	public Integer getPatientid() {
		return patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
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
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public List<Procedure> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<Procedure> procedures) {
		this.procedures = procedures;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public List<MedicalCard> getMedicalcards() {
		return medicalcards;
	}

	public void setMedicalcards(List<MedicalCard> medicalcards) {
		this.medicalcards = medicalcards;
	}

}
