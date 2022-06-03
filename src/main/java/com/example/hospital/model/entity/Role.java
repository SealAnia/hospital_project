package com.example.hospital.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleid;
	@Column
	private String name;
	@OneToMany(mappedBy = "name")
	private List <User> users;

	public Integer getRoleId() {
		return roleid;
	}

	public void setRoleId(Integer roleid) {
		this.roleid = roleid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List <User> getUsers() {
		return users;
	}

	public void setUsers(List <User> users) {
		this.users = users;
	}
}
