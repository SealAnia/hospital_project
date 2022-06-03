package com.example.hospital.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
}
