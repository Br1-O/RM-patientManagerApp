package com.bo.patientmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Bring Online
 */
@Entity
public class Patient {
    
    enum State {
        ACTIVO,
        ALTA,
        ABANDONO,
        DERIVACION
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String name;
    private String lastName;
    private Date birthday;
    private String gender;
    private String avatar;
    private String address;
    private String city;
    private String country;
    private String phone1;
    private String phone2;
    private String email;
    private String social;
    private String derivedFrom;
    private String derivedTo;
    @Column(length = 4000)
    private String observations;
    
    @OneToMany(mappedBy = "patient")
    private List<Session> sessions;
    
    @OneToMany(mappedBy = "patient")
    private List<Relative> relatives;
    
    private boolean isCurrentPatient;
    private State state;

    public Patient() {
        this.isCurrentPatient = true;
        this.state = State.ACTIVO;
    }

    public Patient(Long patientId, 
            String name, 
            String lastName, 
            Date birthday, 
            String gender, 
            String avatar, 
            String address, 
            String city, 
            String country, 
            String phone1, 
            String phone2, 
            String email, 
            String social, 
            String derivedFrom, 
            String initialObservations, 
            List<Session> sessions) {
        this.patientId = patientId;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.avatar = avatar;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.social = social;
        this.derivedFrom = derivedFrom;
        this.observations = initialObservations;
        this.sessions = sessions;
        this.isCurrentPatient = true;
        this.state = State.ACTIVO;
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }
    
    public String getLastName() {
        return lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }
    
    public String getAvatar() {
        return avatar;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getEmail() {
        return email;
    }

    public String getSocial() {
        return social;
    }

    public String getDerivedFrom() {
        return derivedFrom;
    }
    
    public String getDerivedTo() {
        return derivedTo;
    }

    public String getInitialObservations() {
        return observations;
    }

    public boolean isIsCurrentPatient() {
        return isCurrentPatient;
    }

    public State getState() {
        return state;
    }

    public List<Session> getSessions() {
        return sessions;
    }
    
    public List<Relative> getRelatives() {
        return relatives;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public void setDerivedFrom(String derivedFrom) {
        this.derivedFrom = derivedFrom;
    }
    
    public void setDerivedTo(String derivedTo) {
        this.derivedTo = derivedTo;
    }

    public void setInitialObservations(String initialObservations) {
        this.observations = initialObservations;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public void setRelatives(List<Relative> relatives) {
        this.relatives = relatives;
    }

    public void setIsCurrentPatient(boolean isCurrentPatient) {
        this.isCurrentPatient = isCurrentPatient;
    }

    public void setState(State state) {
        this.state = state;
    }
}
