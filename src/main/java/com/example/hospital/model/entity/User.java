package com.example.hospital.model.entity;

import java.util.ArrayList;
import java.util.Collection;
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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user")
public class User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	private boolean accountnotexpired;
	@Column
	private boolean accountnotlocked;
	@Column
	private boolean credentialsnotexpired;
	@Column
	private boolean enabled;
	
	@ManyToOne
	@JoinColumn(name = ("deptid"))
	private Department dept;
	@ManyToOne
	@JoinColumn(name = "roleid")
	private Role role;
	@OneToMany(mappedBy = "user")
	private List<Medicine> medicines;
	@OneToMany(mappedBy = "user")
	private List<Procedure> procedures;
	@OneToMany(mappedBy = "user")
	private List<Operation> operations;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MedicalCard> medicalcards;
	
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

	public List<MedicalCard> getMedicalcards() {
		return medicalcards;
	}

	public void setMedicalcards(List<MedicalCard> medicalcards) {
		this.medicalcards = medicalcards;
	}
	
	public boolean isAccountnotexpired() {
		return accountnotexpired;
	}

	public void setAccountnotexpired(boolean accountnotexpired) {
		this.accountnotexpired = accountnotexpired;
	}

	public boolean isAccountnotlocked() {
		return accountnotlocked;
	}

	public void setAccountnotlocked(boolean accountnotlocked) {
		this.accountnotlocked = accountnotlocked;
	}

	public boolean isCredentialsnotexpired() {
		return credentialsnotexpired;
	}

	public void setCredentialsnotexpired(boolean credentialsnotexpired) {
		this.credentialsnotexpired = credentialsnotexpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	//UserDetails
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		var authorities = new ArrayList<GrantedAuthority>();
		List<Role> roles = new ArrayList<Role>();
		for(Role role: roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
