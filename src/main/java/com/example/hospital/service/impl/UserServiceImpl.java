package com.example.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.hospital.model.entity.Role;
import com.example.hospital.model.entity.User;
import com.example.hospital.model.repository.UserRepository;
import com.example.hospital.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getById(Integer userid) {
		return userRepository.getById(userid);
	}

	@Override
	public User createOrUpdate(User user) {
		return userRepository.saveAndFlush(user);
	}
	
	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

	@Override
	public List<User> search(String keyword) {
		return userRepository.search(keyword);
	}

	@Override
	public List<User> getUserByRole(Role role) {
		return userRepository.getUserByRole(role);
	}

	@Override
	public List<User> getUserByName(String name) {
		return userRepository.getUserByName(name);
	}

	@Override
	public List<User> getUserBySurname(String surname) {
		return userRepository.getUserBySurname(surname);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}
	
}
