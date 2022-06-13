package com.example.hospital.service;

import java.util.Date;
import java.util.List;

import com.example.hospital.model.entity.Procedure;

public interface ProcedureService extends DefaultService<Procedure> {
	
	List<Procedure> getProcedureByName(String name);
	List<Procedure> getProcedureByDate(Date date);
	List<Procedure> getByDateBetween(Date dateFirst, Date dateSecond);
	
	List<Procedure> sortProcedureByNameAsc();
	List<Procedure> sortProcedureByNameDesc();
	List<Procedure> sortProcedureByDateAsc();
	List<Procedure> sortProcedureByDateDesc();
	
}
