package com.example.hospital.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String name;
	@OneToMany(mappedBy = "dept")
	private List<User> users;
	@OneToMany(mappedBy = "dept")
	private List<Patient> patients;

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

	//public List<User> getUsers() {
		//return users;
	//}

	//public void setUsers(List<User> users) {
		//this.users = users;
	//}

	//public List<Patient> getPatients() {
		//return patients;
	//}

	//public void setPatients(List<Patient> patients) {
		//this.patients = patients;
	//}
	
}
