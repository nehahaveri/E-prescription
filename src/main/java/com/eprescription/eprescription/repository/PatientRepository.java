package com.eprescription.eprescription.repository;

import com.eprescription.eprescription.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}