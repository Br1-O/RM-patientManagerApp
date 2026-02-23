/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.service;

import jakarta.persistence.EntityManagerFactory;

/**
 *
 * @author Bring Online
 */
public class ServiceManager {
    EntityManagerFactory em = null;
    private PatientService patientService = null;
    private SessionService sessionService = null;
    private PatientRelativeRelationService patientRelativeRelationService = null;
    private RelativeObservationService relativeObservationService = null;
    private RelativeService relativeService = null;

    public ServiceManager(EntityManagerFactory em) {
        this.em = em;
        patientService = new PatientService(em);
        sessionService = new SessionService(em);
        patientRelativeRelationService = new PatientRelativeRelationService(em);
        relativeObservationService = new RelativeObservationService(em);
        relativeService = new RelativeService(em);
    }

    public EntityManagerFactory getEm() {
        return em;
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public SessionService getSessionService() {
        return sessionService;
    }

    public PatientRelativeRelationService getPatientRelativeRelationService() {
        return patientRelativeRelationService;
    }

    public RelativeObservationService getRelativeObservationService() {
        return relativeObservationService;
    }

    public RelativeService getRelativeService() {
        return relativeService;
    }
    
}
