package com.eprescription.eprescription.controller;

import com.eprescription.eprescription.entity.Prescription;
import com.eprescription.eprescription.service.PrescriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    // ✅ Create Prescription
    @PostMapping("/doctor/{doctorId}/patient/{patientId}")
    public Prescription createPrescription(@PathVariable Long doctorId,
                                           @PathVariable Long patientId,
                                           @RequestBody Prescription prescription) {
        return prescriptionService.createPrescription(doctorId, patientId, prescription);
    }

    // ✅ Get Patient Prescription History
    @GetMapping("/patient/{patientId}")
    public List<Prescription> getPatientPrescriptions(@PathVariable Long patientId) {
        return prescriptionService.getPrescriptionsByPatient(patientId);
    }
}