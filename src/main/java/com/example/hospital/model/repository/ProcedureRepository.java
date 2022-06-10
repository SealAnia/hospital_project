package com.example.hospital.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.hospital.model.entity.Procedure;

@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {
	
	List<Procedure> getProcedureByName(String name);
	List<Procedure> getProcedureByDate(Date date);
	@Query(value = "SELECT p FROM Procedure p WHERE p.procedureid LIKE '%' || :keyword || '%'"
			+ "OR p.name LIKE '%' || :keyword || '%'"
			+ "OR p.date LIKE '%' || :keyword || '%'"
			+ "OR p.details LIKE '%' || :keyword || '%'")
	List<Procedure> search(String keyword);
	
}
