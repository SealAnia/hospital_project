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
	@Column
	private Date release;
	@Column
	private String comments;
	//@Column
	//private Integer departmentid;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "departmentid")
	private Department dept;
	@OneToMany(mappedBy = "patient")
	private List<Medicine> medicines;
	@OneToMany(mappedBy = "patient")
	private List<Procedure> procedures;
	@OneToMany(mappedBy = "patient")
	private List<Operation> operations;
	
	public Integer getPatientId() {
		return patientid;
	}

	public void setPatientId(Integer patientid) {
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

	public Department getDepartment() {
		return dept;
	}

	public void setDepartment(Department dept) {
		this.dept = dept;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
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

}
