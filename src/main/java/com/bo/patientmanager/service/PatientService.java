/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.service;

/**
 *
 * @author Bring Online
 */
import com.bo.patientmanager.model.Patient;
import com.bo.patientmanager.repository.PatientRepository;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(EntityManagerFactory emf) {
        this.patientRepository = new PatientRepository(emf);
    }

    public Patient create(Patient p) {
        return patientRepository.create(p);
    }

    public Patient update(Patient p) {
        return patientRepository.update(p);
    }

    public Patient findById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
}

    

