package com.example.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.model.entity.Role;
import com.example.hospital.model.repository.RoleRepository;
import com.example.hospital.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> getAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role getById(Integer id) {
		return roleRepository.findById(id).orElse(new Role());
	}

	@Override
	public void createOrUpdate(Role role) {
		roleRepository.saveAndFlush(role);
	}

	@Override
	public void delete(Integer id) {
		roleRepository.deleteById(id);
	}

	@Override
	public void delete(Role role) {
		roleRepository.delete(role);
	}

}
