/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.service;

import com.bo.patientmanager.model.PatientRelativeRelation;
import com.bo.patientmanager.model.RelativeObservation;
import com.bo.patientmanager.model.Session;
import com.bo.patientmanager.repository.PatientRelativeRelationRepository;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

/**
 *
 * @author Bring Online
 */
public class PatientRelativeRelationService {
   private final PatientRelativeRelationRepository patientRelativeRelationRepository;

    public PatientRelativeRelationService(EntityManagerFactory emf) {
        this.patientRelativeRelationRepository = new PatientRelativeRelationRepository(emf);
    }

    public PatientRelativeRelation create(PatientRelativeRelation p) {
        return patientRelativeRelationRepository.create(p);
    }

    public PatientRelativeRelation update(PatientRelativeRelation p) {
        return patientRelativeRelationRepository.update(p);
    }

    public PatientRelativeRelation findById(Long id) {
        return patientRelativeRelationRepository.findById(id);
    }

    public List<PatientRelativeRelation> findAll() {
        return patientRelativeRelationRepository.findAll();
    }
    
    public List<PatientRelativeRelation> findByPatient(Long patientId) {
        return patientRelativeRelationRepository.findByPatientId(patientId);
    }
}
