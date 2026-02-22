/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.service;

import com.bo.patientmanager.model.RelativeObservation;
import com.bo.patientmanager.repository.RelativeObservationRepository;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

/**
 *
 * @author Bring Online
 */
public class RelativeObservationService {
    private final RelativeObservationRepository relativeObservationRepository;

    public RelativeObservationService(EntityManagerFactory emf) {
        this.relativeObservationRepository = new RelativeObservationRepository(emf);
    }

    public RelativeObservation create(RelativeObservation p) {
        return relativeObservationRepository.create(p);
    }

    public RelativeObservation update(RelativeObservation p) {
        return relativeObservationRepository.update(p);
    }

    public RelativeObservation findById(Long id) {
        return relativeObservationRepository.findById(id);
    }

    public List<RelativeObservation> findAll() {
        return relativeObservationRepository.findAll();
    }
    
    public List<RelativeObservation> findByRelation(Long relationId){
        return relativeObservationRepository.findByRelation(relationId);
    }
}
