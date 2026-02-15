package com.bo.patientmanager.model;

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
public class Patient {
    
    private int patientId;
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
    private String initialObservations;
    
    private List<Session> sessions;
    private Relative mainRelative;

    public Patient() {
    }

    public Patient(int patientId, String name, String lastName, Date birthday, String gender, String avatar, String address, String city, String country, String phone1, String phone2, String email, String social, String derivedFrom, String initialObservations, List<Session> sessions) {
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
        this.initialObservations = initialObservations;
        this.sessions = sessions;
    }

    public int getPatientId() {
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

    public String getInitialObservations() {
        return initialObservations;
    }

    public List<Session> getSessions() {
        return sessions;
    }
    
    public Relative getMainRelative() {
        return mainRelative;
    }

    public void setPatientId(int patientId) {
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

    public void setInitialObservations(String initialObservations) {
        this.initialObservations = initialObservations;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public void setMainRelative(Relative mainRelative) {
        this.mainRelative = mainRelative;
    }
    
    
    
    
}
