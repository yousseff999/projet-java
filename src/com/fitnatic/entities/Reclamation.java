/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnatic.entities;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Youssef
 */
public class Reclamation {
    private int reclamationId;
    private int userId;
    private Date date;
    private String description;

    public Reclamation() {
    }

    public Reclamation(int reclamationId, int userId, Date date, String description) {
        this.reclamationId = reclamationId;
        this.userId = userId;
        this.date = date;
        this.description = description;
    }

    public int getReclamationId() {
        return reclamationId;
    }

    public void setReclamationId(int reclamationId) {
        this.reclamationId = reclamationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "reclamationId=" + reclamationId + ", userId=" + userId + ", date=" + date + ", description=" + description + '}';
    }

    
}