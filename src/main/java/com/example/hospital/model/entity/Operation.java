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
@Table(name = "operation")
public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private Date date;
	@Column
	private String comments;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientid")
	private Patient patient;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private User user;
	
	@OneToMany(mappedBy = "operation", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MedicalCard> medicalcards;
	
	public Operation() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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
