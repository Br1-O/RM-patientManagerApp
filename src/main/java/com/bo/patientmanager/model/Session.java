/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.model;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 *
 * @author Bring Online
 */
public class Session {
    private int id;
    private int patientId;
    private DayOfWeek dayOfWeek;
    private LocalTime from;
    private LocalTime to;
    private String mode;
    private String difBillingRate;
    private String currency;

    public Session() {
    }

    public Session(int id, int patientId, DayOfWeek dayOfWeek, LocalTime from, LocalTime to, String mode, String difBillingRate, String currency) {
        this.id = id;
        this.patientId = patientId;
        this.dayOfWeek = dayOfWeek;
        this.from = from;
        this.to = to;
        this.mode = mode;
        this.difBillingRate = difBillingRate;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public int getPatientId() {
        return patientId;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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
