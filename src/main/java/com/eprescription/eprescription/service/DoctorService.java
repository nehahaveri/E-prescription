package com.eprescription.eprescription.service;

import com.eprescription.eprescription.entity.Doctor;
import com.eprescription.eprescription.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Register Doctor
    public Doctor registerDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Get Doctor By Id
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    // Get All Doctors (ADD THIS)
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Delete Doctor (ADD THIS)
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}