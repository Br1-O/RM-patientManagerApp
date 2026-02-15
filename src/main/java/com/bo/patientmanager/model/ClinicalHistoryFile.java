/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.model;

import java.util.List;

/**
 *
 * @author Bring Online
 */
public class ClinicalHistoryFile {
    private int id;
    private int clinicalHistoryId;
    private String path;
    private String fileType;
    private String description;
    private List<String> keyWords;

    public ClinicalHistoryFile() {
    }

    public ClinicalHistoryFile(int id, int clinicalHistoryId, String path, String fileType, String description, List<String> keyWords) {
        this.id = id;
        this.clinicalHistoryId = clinicalHistoryId;
        this.path = path;
        this.fileType = fileType;
        this.description = description;
        this.keyWords = keyWords;
    }

    public int getId() {
        return id;
    }

    public int getClinicalHistoryId() {
        return clinicalHistoryId;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setClinicalHistoryId(int clinicalHistoryId) {
        this.clinicalHistoryId = clinicalHistoryId;
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
