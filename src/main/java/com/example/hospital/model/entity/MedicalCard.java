package com.example.hospital.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicalcard")
public class MedicalCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer medicalcardid;
	
	@ManyToOne
	@JoinColumn(name = "patientid")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "medicineid")
	private Medicine medicine;
	
	@ManyToOne
	@JoinColumn(name = "operationid")
	private Operation operation;
	
	@ManyToOne
	@JoinColumn(name = "procedureid")
	private Procedure procedure;
	
	public Integer getMedicalcardid() {
		return medicalcardid;
	}

	public void setMedicalcardid(Integer medicalcardid) {
		this.medicalcardid = medicalcardid;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

}
