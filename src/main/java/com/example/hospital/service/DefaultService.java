package com.example.hospital.service;

import java.util.List;
import java.util.Optional;

public interface DefaultService<T> {
	
	List<T> getAll();
	T getById(Integer id);
	void createOrUpdate(T entity);
	void delete(Integer id);
	void delete(T entity);
	//T edit(T entity);

}
