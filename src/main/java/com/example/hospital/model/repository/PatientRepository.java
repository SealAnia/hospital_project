package com.example.hospital.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hospital.model.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	List<Patient> getPatientByName(String name);
	List<Patient> getPatientBySurname(String surname);
	List<Patient> getPatientByDiagnosis(String diagnosis);
	List<Patient> getPatientByAdmission(Date admission);
	List<Patient> getPatientByRelease(Date release);
	@Query(value = "SELECT p FROM Patient p WHERE p.patientid LIKE '%' || :keyword || '%'"
			+ "OR p.name LIKE '%' || :keyword || '%'"
			+ "OR p.surname LIKE '%' || :keyword || '%'"
			+ "OR p.diagnosis LIKE '%' || :keyword || '%'"
			+ "OR p.admission LIKE '%' || :keyword || '%'"
			+ "OR p.release LIKE '%' || :keyword || '%'"
			+ "OR p.comments LIKE '%' || :keyword || '%'"
			+ "OR p.department.name LIKE '%' || :keyword || '%'")
	List<Patient> search(@Param("keyword") String keyword);
	
	@Query(value = "SELECT p FROM Patient p WHERE p.name LIKE '%' || :name || '%' "
			+ "AND p.surname LIKE '%' || :surname || '%' ORDER BY p.department.name")
	List<Patient> getByNameAndSurname(@Param("name") String name, 
			@Param("surname") String surname);
	

}
