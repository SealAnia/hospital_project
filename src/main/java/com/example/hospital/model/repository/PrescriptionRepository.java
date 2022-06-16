package com.example.hospital.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.model.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

}
