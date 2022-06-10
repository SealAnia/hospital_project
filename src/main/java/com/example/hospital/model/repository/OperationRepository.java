package com.example.hospital.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.hospital.model.entity.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer> {
	
	List<Operation> getOperationByDate(Date date);
	@Query(value = "SELECT o FROM Operation o WHERE o.id LIKE '%' || :keyword || '%'"
			+ "OR o.date LIKE '%' || :keyword || '%'"
			+ "OR o.comments LIKE '%' || :keyword || '%'")
	List<Operation> search(String keyword);
	
	@Query(value = 
			"SELECT o FROM Operation o WHERE o.date BETWEEN '%' || :dateFirst || '%' AND '%' || :dateSecond || '%'")
	List<Operation> getByDateBetween(Date dateFirst, Date dateSecond);

}
