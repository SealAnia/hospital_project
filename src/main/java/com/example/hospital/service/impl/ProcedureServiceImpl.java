package com.example.hospital.service.impl;

import java.util.Date;
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
	public Procedure createOrUpdate(Procedure procedure) {
		return procedureRepository.saveAndFlush(procedure);
	}
	
	@Override
	public void delete(Procedure procedure) {
		procedureRepository.delete(procedure);
	}

	@Override
	public List<Procedure> search(String keyword) {
		return procedureRepository.search(keyword);
	}

	@Override
	public List<Procedure> getProcedureByName(String name) {
		return procedureRepository.getProcedureByName(name);
	}

	@Override
	public List<Procedure> getProcedureByDate(Date date) {
		return procedureRepository.getProcedureByDate(date);
	}
	
	@Override
	public List<Procedure> getByDateBetween(Date dateFirst, Date dateSecond) {
		return procedureRepository.getByDateBetween(dateFirst, dateSecond);
	}

}
