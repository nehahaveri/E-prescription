package com.eprescription.eprescription.repository;

import com.eprescription.eprescription.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByEmail(String email);
}

// simple changes make life better