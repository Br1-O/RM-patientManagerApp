/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

/**
 *
 * @author Bring Online
 */
public class RelativeObservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relativeObservationId;
    
    @ManyToOne
    @JoinColumn(name = "patient_relative_id", nullable = false)
    private PatientRelativeRelation patientRelativeRelation;
        
    private Date date;
    @Column(length = 4000)
    private String content;

    public RelativeObservation() {
    }

    public RelativeObservation(Long relativeObservationId, PatientRelativeRelation patientRelativeRelation, Date date, String content) {
        this.relativeObservationId = relativeObservationId;
        this.patientRelativeRelation = patientRelativeRelation;
        this.date = date;
        this.content = content;
    }

    public Long getRelativeObservationId() {
        return relativeObservationId;
    }
    
    public PatientRelativeRelation getPatientRelativeRelation() {
        return patientRelativeRelation;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void setRelativeObservationId(Long relativeObservationId) {
        this.relativeObservationId = relativeObservationId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public void setPatientRelativeRelation(PatientRelativeRelation patientRelativeRelation) {
        this.patientRelativeRelation = patientRelativeRelation;
    }

}

