package com.example.hospital.service;

import java.util.List;

import com.example.hospital.model.entity.Role;
import com.example.hospital.model.entity.User;

public interface UserService extends DefaultService<User> {
	
	//List<User> getUserByRoleid(Integer roleid);
	
	List<User> getUserByRole(Role role);
	List<User> getUserByName(String name);
	List<User> getUserBySurname(String surname);
	
}
