/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bring Online
 */
@Entity
public class ClinicalHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clinicHistoryId; //main id for db
    private String clinicHistoryCode; //use this one for search by user
    private Date sessionDate;
    @Column(length = 4000)
    private String content;
    @Column(length = 4000)
    private String observation;
    @Column(length = 4000)
    private String conclusion;
    private List<String> keyWords;
    
    @OneToMany(mappedBy = "clinicalHistory")
    private List<ClinicalHistoryFile> files;
    
    private String psychologistName;

    public ClinicalHistory() {
    }

    public ClinicalHistory(int clinicHistoryId, String clinicHistoryCode, Date sessionDate, String content, String observation, String conclusion, List<String> keyWords, List<ClinicalHistoryFile> files, String psychologistName) {
        this.clinicHistoryId = clinicHistoryId;
        this.clinicHistoryCode = clinicHistoryCode;
        this.sessionDate = sessionDate;
        this.content = content;
        this.observation = observation;
        this.conclusion = conclusion;
        this.keyWords = keyWords;
        this.files = files;
        this.psychologistName = psychologistName;
    }

    public int getClinicHistoryId() {
        return clinicHistoryId;
    }

    public String getClinicHistoryCode() {
        return clinicHistoryCode;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public String getContent() {
        return content;
    }

    public String getObservation() {
        return observation;
    }

    public String getConclusion() {
        return conclusion;
    }

    public List<String> getKeyWords() {
        return keyWords;
    }

    public List<ClinicalHistoryFile> getFiles() {
        return files;
    }

    public String getPsychologistName() {
        return psychologistName;
    }

    public void setClinicHistoryId(int clinicHistoryId) {
        this.clinicHistoryId = clinicHistoryId;
    }

    public void setClinicHistoryCode(String clinicHistoryCode) {
        this.clinicHistoryCode = clinicHistoryCode;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }

    public void setFiles(List<ClinicalHistoryFile> files) {
        this.files = files;
    }

    public void setPsychologistName(String psychologistName) {
        this.psychologistName = psychologistName;
    }
    
    
}
