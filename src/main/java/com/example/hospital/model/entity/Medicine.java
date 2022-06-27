package com.example.hospital.model.entity;

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
@Table(name = "medicine")
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String name;
	@Column(name = "numberperday")
	private Double numberPerDay;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientid")
	private Patient patient;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private User user;
	
	@OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL, 
			orphanRemoval = true)
	private List<Prescription> prescriptions;
	
	@OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MedicalCard> medicalcards;
	
	public Medicine() {
		
	}
	
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
