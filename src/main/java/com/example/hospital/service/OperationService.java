package com.example.hospital.service;

import java.util.Date;
import java.util.List;

import com.example.hospital.model.entity.Operation;

public interface OperationService extends DefaultService<Operation> {
	
	List<Operation> getOperationByDate(Date date);
	List<Operation> getByDateBetween(Date dateFirst, Date dateSecond);
	
}
