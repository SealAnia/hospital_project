package com.example.hospital.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.hospital.model.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
	
	List<Medicine> getMedicineByName(String name);
	@Query(value = "SELECT m FROM Medicine m WHERE m.id LIKE '%' || :keyword || '%'" 
			+ "OR m.name LIKE '%' || :keyword || '%'"
			+ "OR m.numberPerDay LIKE '%' || :keyword || '%'")
	List<Medicine> search(String keyword);
	
}
