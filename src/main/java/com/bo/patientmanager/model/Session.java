/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 *
 * @author Bring Online
 */
@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;    
    
    private DayOfWeek dayOfWeek;
    private LocalTime from;
    private LocalTime to;
    private String mode;
    private String difBillingRate;
    private String currency;

    public Session() {
    }

    public Session(Long id, Patient patient, DayOfWeek dayOfWeek, LocalTime from, LocalTime to, String mode, String difBillingRate, String currency) {
        this.id = id;
        this.patient = patient;
        this.dayOfWeek = dayOfWeek;
        this.from = from;
        this.to = to;
        this.mode = mode;
        this.difBillingRate = difBillingRate;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getFrom() {
        return from;
    }

    public LocalTime getTo() {
        return to;
    }

    public String getMode() {
        return mode;
    }

    public String getDifBillingRate() {
        return difBillingRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setFrom(LocalTime from) {
        this.from = from;
    }

    public void setTo(LocalTime to) {
        this.to = to;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setDifBillingRate(String difBillingRate) {
        this.difBillingRate = difBillingRate;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    
}
