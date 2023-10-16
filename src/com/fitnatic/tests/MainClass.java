/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**/package com.fitnatic.tests;

import com.fitnatic.entities.Reclamation;
import com.fitnatic.services.ReclamationCrud;
import com.fitnatic.utils.MyConnection;

/**
 *
 * @author Youssef
 */
public class MainClass {
    public static void main(String[] args) {
        MyConnection mc = MyConnection.getInstance(); // Utilisez la méthode pour obtenir une instance de connexion
        ReclamationCrud pcd = new ReclamationCrud();
        Reclamation r = new Reclamation();
        pcd.ajouterReclamation(r);
        pcd.modifierReclamation(9, "Taraji");
        pcd.supprimerReclamation(10);
   }
}
