package com.example.hospital.model.repository;

import org.springframework.stereotype.Repository;

import com.example.hospital.model.entity.Department;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
	List<Department> getDepartmentByName(String name);
	//Iterable<Department> sortDepartmentsByName(Sort sort);
	
}
