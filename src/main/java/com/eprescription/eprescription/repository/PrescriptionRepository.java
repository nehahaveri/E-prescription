package com.eprescription.eprescription.repository;

import com.eprescription.eprescription.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    // 🔹 Get all prescriptions of a specific patient
    List<Prescription> findByPatientId(Long patientId);
}