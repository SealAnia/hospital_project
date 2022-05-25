package com.example.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.model.entity.Operation;
import com.example.hospital.model.repository.OperationRepository;
import com.example.hospital.service.OperationService;

@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	private OperationRepository operationRepository;

	@Override
	public List<Operation> getAll() {
		return operationRepository.findAll();
	}

	@Override
	public Operation getById(Integer id) {
		return operationRepository.findById(id).orElse(new Operation());
	}

	@Override
	public void createOrUpdate(Operation operation) {
		operationRepository.saveAndFlush(operation);
	}

	@Override
	public void delete(Integer id) {
		operationRepository.deleteById(id);
	}

	@Override
	public void delete(Operation operation) {
		operationRepository.delete(operation);
	}

}
