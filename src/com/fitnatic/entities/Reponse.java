/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnatic.entities;

import java.util.Date;

/**
 *
 * @author Youssef
 */
public class Reponse {
    private int reponseId; // Identifiant unique de la réponse
    private int reclamationId; // Identifiant de la réclamation à laquelle cette réponse est associée
    private Date dateCreation; // Date de création de la réponse
    private String contenu; // Contenu de la réponse

    public Reponse(int reponseId, int reclamationId, Date dateCreation, String contenu) {
        this.reponseId = reponseId;
        this.reclamationId = reclamationId;
        this.dateCreation = dateCreation;
        this.contenu = contenu;
    }

    public Reponse(int reponseId, int reclamationId, String contenu) {
        this.reponseId = reponseId;
        this.reclamationId = reclamationId;
        this.contenu = contenu;
    }

    public Reponse(int reponseId, int reclamationId) {
        this.reponseId = reponseId;
        this.reclamationId = reclamationId;
    }

    public int getReponseId() {
        return reponseId;
    }

    public void setReponseId(int reponseId) {
        this.reponseId = reponseId;
    }

    public int getReclamationId() {
        return reclamationId;
    }

    public void setReclamationId(int reclamationId) {
        this.reclamationId = reclamationId;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Reponse{" + "reponseId=" + reponseId + ", reclamationId=" + reclamationId + ", dateCreation=" + dateCreation + ", contenu=" + contenu + '}';
    }
    
    
}
