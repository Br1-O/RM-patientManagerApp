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
import java.util.List;

/**
 *
 * @author Bring Online
 */
@Entity
public class ClinicalHistoryFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name= "clinical_history_id", nullable = false)
    private ClinicalHistory clinicalHistory;
    
    private String path;
    private String fileType;
    private String description;
    private List<String> keyWords;

    public ClinicalHistoryFile() {
    }

    public ClinicalHistoryFile(ClinicalHistory clinicalHistory, String path, String fileType, String description, List<String> keyWords) {
        this.clinicalHistory = clinicalHistory;
        this.path = path;
        this.fileType = fileType;
        this.description = description;
        this.keyWords = keyWords;
    }

    public Long getId() {
        return id;
    }

    public ClinicalHistory getClinicalHistory() {
        return clinicalHistory;
    }

    public String getPath() {
        return path;
    }

    public String getFileType() {
        return fileType;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getKeyWords() {
        return keyWords;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClinicalHistory(ClinicalHistory clinicalHistory) {
        this.clinicalHistory = clinicalHistory;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }
    
    
}
