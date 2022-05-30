package com.example.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.model.entity.Procedure;
import com.example.hospital.model.repository.ProcedureRepository;
import com.example.hospital.service.ProcedureService;

@Service
public class ProcedureServiceImpl implements ProcedureService {
	
	@Autowired
	private ProcedureRepository procedureRepository;
	
	@Override
	public List<Procedure> getAll() {
		return procedureRepository.findAll();
	}

	@Override
	public Procedure getById(Integer id) {
		return procedureRepository.getById(id);
	}

	@Override
	public void createOrUpdate(Procedure procedure) {
		procedureRepository.saveAndFlush(procedure);
	}

	@Override
	public void delete(Integer id) {
		procedureRepository.deleteById(id);
	}

	@Override
	public void delete(Procedure procedure) {
		procedureRepository.delete(procedure);
	}

	@Override
	public List<Procedure> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
