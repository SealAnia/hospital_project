package com.example.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.model.entity.User;
import com.example.hospital.model.repository.UserRepository;
import com.example.hospital.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getById(Integer id) {
		return userRepository.findById(id).orElse(new User());
	}

	@Override
	public void createOrUpdate(User user) {
		userRepository.saveAndFlush(user);
	}

	@Override
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

}
