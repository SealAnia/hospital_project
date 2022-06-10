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
	//@Column
	//private Integer deptid;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = ("deptid"))
	private Department dept;
	//@Column
	//private Integer roleid;
	@ManyToOne
	@JoinColumn(name = "roleid")
	private Role role;
	@OneToMany(mappedBy = "user")
	private List<Medicine> medicines;
	@OneToMany(mappedBy = "user")
	private List<Procedure> procedures;
	@OneToMany(mappedBy = "user")
	private List<Operation> operations;
	
	public User() {
		
	}
	
	public User(Integer userid, String name, String surname, String login, 
			String password, Department dept, Role role, 
			List<Medicine> medicines, List<Procedure> procedures, List<Operation> operations) {
		this.userid = userid;
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.dept = dept;
		this.role = role;
		this.medicines = medicines;
		this.procedures = procedures;
		this.operations = operations;
	}
	
	public User(Integer userid, String name, String surname, String login, 
			String password, Department dept, Role role, 
			List<Medicine> medicines, List<Procedure> procedures) {
		this.userid = userid;
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.dept = dept;
		this.role = role;
		this.medicines = medicines;
		this.procedures = procedures;
	}
	
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
	
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
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
