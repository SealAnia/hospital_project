package com.example.hospital.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
		return operationRepository.getById(id);
	}

	@Override
	public Operation createOrUpdate(Operation operation) {
		return operationRepository.saveAndFlush(operation);
	}
	
	@Override
	public void delete(Operation operation) {
		operationRepository.delete(operation);
	}

	@Override
	public List<Operation> search(String keyword) {
		return operationRepository.search(keyword);
	}

	@Override
	public List<Operation> getOperationByDate(Date date) {
		return operationRepository.getOperationByDate(date);
	}

	@Override
	public Iterable<Operation> sortOperationsByDateAsc() {
		return operationRepository.findAll(Sort.by(Direction.ASC, "date"));
	}

	@Override
	public Iterable<Operation> sortOperationsByDateDesc() {
		return operationRepository.findAll(Sort.by(Direction.DESC, "date"));
	}

	@Override
	public List<Operation> getByDateBetween(Date dateFirst, Date dateSecond) {
		return operationRepository.getByDateBetween(dateFirst, dateSecond);
	}

}
