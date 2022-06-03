package com.example.hospital.model.entity;

import java.util.Date;

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
	
	public Integer getProcedureId() {
		return procedureid;
	}

	public void setProcedureId(Integer procedureid) {
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
	
}
