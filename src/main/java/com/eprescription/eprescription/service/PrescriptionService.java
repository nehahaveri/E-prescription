package com.eprescription.eprescription.service;

import com.eprescription.eprescription.entity.*;
import com.eprescription.eprescription.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository,
                               DoctorRepository doctorRepository,
                               PatientRepository patientRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    // ✅ Create Prescription
    public Prescription createPrescription(Long doctorId,
                                           Long patientId,
                                           Prescription prescription) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // 🔒 Security validation
        if (!patient.getDoctor().getId().equals(doctorId)) {
            throw new RuntimeException("This patient does not belong to this doctor");
        }

        prescription.setDoctor(doctor);
        prescription.setPatient(patient);

        // If visitDate not sent, set today's date
        if (prescription.getVisitDate() == null) {
            prescription.setVisitDate(LocalDate.now());
        }

        // Attach items properly
        if (prescription.getItems() != null) {
            prescription.getItems().forEach(item -> item.setPrescription(prescription));
        }

        return prescriptionRepository.save(prescription);
    }

    // ✅ Get all prescriptions of a patient
    public List<Prescription> getPrescriptionsByPatient(Long patientId) {
        return prescriptionRepository.findByPatientId(patientId);
    }
}