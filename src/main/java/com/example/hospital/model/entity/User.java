package com.example.hospital.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String login;
	@Column
	private String password;
	@Column
	private Integer deptid;
	@Column
	private Integer roleid;
	@OneToOne
	@JoinColumn(name = "userid")
	private Role role;
	
	public Integer getUserId() {
		return userid;
	}
	public void setUserId(Integer userid) {
		this.userid = userid;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getDepartmentId() {
		return deptid;
	}
	public void setDepartmentId(Integer deptid) {
		this.deptid = deptid;
	}
	public Integer getRoleId() {
		return roleid;
	}
	public void setRoleId(Integer roleid) {
		this.roleid = roleid;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}
