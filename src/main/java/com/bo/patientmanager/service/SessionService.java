/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.service;

import com.bo.patientmanager.model.Session;
import com.bo.patientmanager.repository.SessionRepository;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

/**
 *
 * @author Bring Online
 */
public class SessionService {
    private final SessionRepository sessionRepository;

    public SessionService(EntityManagerFactory emf) {
        this.sessionRepository = new SessionRepository(emf);
    }

    public Session create(Session p) {
        return sessionRepository.create(p);
    }

    public Session update(Session p) {
        return sessionRepository.update(p);
    }

    public Session findById(Long id) {
        return sessionRepository.findById(id);
    }

    public List<Session> findAll() {
        return sessionRepository.findAll();
    }
    
    public Long countByPatient(Long patientId) {
        return sessionRepository.countByPatientId(patientId);
    }
    
    public List<Session> findByPatient(Long patientId) {
        return sessionRepository.findByPatientId(patientId);
    }
}
