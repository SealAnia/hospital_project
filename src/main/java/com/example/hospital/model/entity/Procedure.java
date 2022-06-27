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
@Table(name = "procedureinfo")
public class Procedure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer procedureid;
	@Column
	private String name;
	@Column
	private String details;
	@Column
	private Date date;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientid")
	private Patient patient;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private User user;
	
	@OneToMany(mappedBy = "procedure", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MedicalCard> medicalcards;
	
	public Procedure() {
		
	}
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<MedicalCard> getMedicalcards() {
		return medicalcards;
	}

	public void setMedicalcards(List<MedicalCard> medicalcards) {
		this.medicalcards = medicalcards;
	}
	
}
