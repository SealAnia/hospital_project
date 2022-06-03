package com.example.hospital.service;

import java.util.List;

public interface DefaultService<T> {
	
	List<T> getAll();
	T getById(Integer id);
	T createOrUpdate(T entity);
	void delete(T entity);
	List<T> search(String keyword);
	
}
