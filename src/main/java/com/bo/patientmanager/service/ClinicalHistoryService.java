/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.service;

import com.bo.patientmanager.model.ClinicalHistory;
import com.bo.patientmanager.repository.ClinicalHistoryRepository;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

/**
 *
 * @author Bring Online
 */
public class ClinicalHistoryService {
    private final ClinicalHistoryRepository clinicalHistoryRepository;

    public ClinicalHistoryService(EntityManagerFactory emf) {
        this.clinicalHistoryRepository = new ClinicalHistoryRepository(emf);
    }

    public ClinicalHistory create(ClinicalHistory p) {
        return clinicalHistoryRepository.create(p);
    }

    public ClinicalHistory update(ClinicalHistory p) {
        return clinicalHistoryRepository.update(p);
    }

    public ClinicalHistory findById(Long id) {
        return clinicalHistoryRepository.findById(id);
    }

    public List<ClinicalHistory> findAll() {
        return clinicalHistoryRepository.findAll();
    }
}
