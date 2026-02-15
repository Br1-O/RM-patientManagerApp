/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.model;

import java.util.Date;

/**
 *
 * @author Bring Online
 */
public class Relative {
    private int relativeId;
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
    private String observations;

    public Relative() {
    }

    public Relative(int relativeId, String name, String lastName, String relation, Date birthday, String gender, String avatar, String address, String city, String country, String phone1, String phone2, String email, String observations) {
        this.relativeId = relativeId;
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
        this.observations = observations;
    }

    public int getRelativeId() {
        return relativeId;
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

    public String getObservations() {
        return observations;
    }

    public void setRelativeId(int relativeId) {
        this.relativeId = relativeId;
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

    public void setObservations(String observations) {
        this.observations = observations;
    }
    
    
}
