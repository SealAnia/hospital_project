package com.example.hospital.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hospital.model.entity.Procedure;

@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {
	
	List<Procedure> getProcedureByName(String name);
	List<Procedure> getProcedureByDate(Date date);
	@Query(value = "SELECT p FROM Procedure p WHERE p.procedureid LIKE '%' || :keyword || '%'"
			+ "OR p.name LIKE '%' || :keyword || '%'"
			+ "OR p.date LIKE '%' || :keyword || '%'"
			+ "OR p.details LIKE '%' || :keyword || '%'"
			+ "OR p.patient.name LIKE '%' || :keyword || '%' "
			+ "OR p.patient.surname LIKE '%' || :keyword || '%'"
			+ "OR p.user.name LIKE '%' || :keyword || '%'"
			+ "OR p.user.surname LIKE '%' || :keyword || '%'")
	List<Procedure> search(String keyword);
	
	@Query(value = 
			"SELECT p FROM Procedure p WHERE p.date BETWEEN :dateFirst "
			+ "AND :dateSecond ORDER BY date ASC")
	List<Procedure> getByDateBetween(@Param("dateFirst") Date dateFirst, @Param("dateSecond") Date dateSecond);
	
	
}
