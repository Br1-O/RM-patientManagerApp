/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

/**
 *
 * @author Bring Online
 */
@Entity
public class PatientRelativeRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Relative relative;

    private String relation;

    @OneToMany(mappedBy = "patientRelativeRelation")
    private List<RelativeObservation> observations;
    
    private boolean isMainContact;

    public PatientRelativeRelation() {
    }

    public PatientRelativeRelation(Patient patient, Relative relative, String relation, List<RelativeObservation> observations, boolean isMainContact) {
        this.patient = patient;
        this.relative = relative;
        this.relation = relation;
        this.observations = observations;
        this.isMainContact = isMainContact;
    }

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Relative getRelative() {
        return relative;
    }

    public String getRelation() {
        return relation;
    }

    public List<RelativeObservation> getObservations() {
        return observations;
    }

    public boolean isIsMainContact() {
        return isMainContact;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setRelative(Relative relative) {
        this.relative = relative;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public void setObservations(List<RelativeObservation> observations) {
        this.observations = observations;
    }

    public void setIsMainContact(boolean isMainContact) {
        this.isMainContact = isMainContact;
    }
}
