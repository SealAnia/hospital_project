package com.example.hospital.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hospital.model.entity.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer> {
	
	List<Operation> getOperationByDate(Date date);
	@Query(value = "SELECT o FROM Operation o WHERE o.id LIKE '%' || :keyword || '%'"
			+ "OR o.date LIKE '%' || :keyword || '%'"
			+ "OR o.comments LIKE '%' || :keyword || '%'"
			+ "OR o.patient.name LIKE '%' || :keyword || '%' "
			+ "OR o.patient.surname LIKE '%' || :keyword || '%'"
			+ "OR o.user.name LIKE '%' || :keyword || '%'"
			+ "OR o.user.surname LIKE '%' || :keyword || '%'")
	List<Operation> search(String keyword);
	
	@Query(value = 
			"SELECT o FROM Operation o WHERE o.date BETWEEN :dateFirst "
			+ "AND :dateSecond ORDER BY date ASC")
	List<Operation> getByDateBetween(@Param("dateFirst") Date dateFirst, @Param("dateSecond") Date dateSecond);
	
}
