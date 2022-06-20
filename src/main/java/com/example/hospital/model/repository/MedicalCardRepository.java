package com.example.hospital.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.model.entity.MedicalCard;

@Repository
public interface MedicalCardRepository extends JpaRepository<MedicalCard, Integer> {

}
