package com.example.hospital.model.repository;

import org.springframework.stereotype.Repository;

import com.example.hospital.model.entity.Department;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
	List<Department> getDepartmentByName(String name);
	@Query(value = "SELECT d FROM Department d WHERE d.name LIKE '%' || :keyword || '%'"
			+ "OR d.id LIKE '%' || :keyword || '%'")
	List<Department> search(@Param("keyword") String keyword);
	
}
