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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bring Online
 */
@Entity
public class Relative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relativeId;
    
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
        
    private String name;
    private String lastName;
    private String relation;
    private Date birthday;
    private String gender;
    private String avatar;
    private String address;
    private String city;
    private String country;
    private String phone1;
    private String phone2;
    private String email;

    public Relative() {
    }

    public Relative(Patient patient, String name, String lastName, String relation, Date birthday, String gender, String avatar, String address, String city, String country, String phone1, String phone2, String email) {
        this.patient = patient;
        this.name = name;
        this.lastName = lastName;
        this.relation = relation;
        this.birthday = birthday;
        this.gender = gender;
        this.avatar = avatar;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
    }

    public Long getRelativeId() {
        return relativeId;
    }
    
    public Patient patient() {
        return patient;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRelation() {
        return relation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }
    
    public String getAvatar() {
        return avatar;
    }

    public String getAddress() {
        return address;
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

    public void setRelativeId(Long relativeId) {
        this.relativeId = relativeId;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRelation(String relation) {
        this.relation = relation;
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
    
}
