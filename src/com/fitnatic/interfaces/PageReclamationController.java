/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnatic.interfaces;

import com.fitnatic.entities.Reclamation;
import com.fitnatic.services.ReclamationCrud;
import com.fitnatic.utils.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class PageReclamationController implements Initializable {

    @FXML
    private TextField userId;
    @FXML
    private TextField description_r;
    @FXML
    private Button retour_rec;
    @FXML
    private Button ajouter_rec;
    @FXML
    private DatePicker date_rec;
    @FXML
    private TableView<Reclamation> tab_rec;
    @FXML
    private TableColumn<Reclamation, Integer> id_col;
    @FXML
    private TableColumn<Reclamation, String> date_col;
    @FXML
    private TableColumn<Reclamation, String> desc_col;
    @FXML
    private Button supp_rec;
    @FXML
    private Button modif_rec;
    
    String query = null;
    MyConnection mc = MyConnection.getInstance();
    PreparedStatement pst = null;
    ResultSet rs = null;
    Reclamation Reclamation = null;
    ReclamationCrud bb= new ReclamationCrud ();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            bb.ShowReclamation(tab_rec, id_col, date_col, desc_col);
        } catch (SQLException ex) {
            Logger.getLogger(PageReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void retour(MouseEvent event) {
         Stage stage = (Stage) retour_rec.getScene().getWindow();
    stage.close(); // Ferme la fenêtre actuelle
    }

    @FXML
    private void ajouter(MouseEvent event) {
      // Récupérez les valeurs des champs du formulaire
    int userIdValue = Integer.parseInt(userId.getText());
    String descriptionValue = description_r.getText();
    LocalDate dateValue = date_rec.getValue();

    // Créez une instance de Reclamation avec les valeurs du formulaire
    Reclamation reclamation = new Reclamation();
    reclamation.setUserId(userIdValue);
    reclamation.setDescription(descriptionValue);
    reclamation.setDate(Date.from(dateValue.atStartOfDay(ZoneId.systemDefault()).toInstant()));

    // Appelez la méthode d'ajout de la classe ReclamationCrud
    ReclamationCrud reclamationCrud = new ReclamationCrud();
    reclamationCrud.ajouterReclamation(reclamation);
}   
    

    @FXML
    private void supprimer(MouseEvent event) {
        int idReclamationASupprimer = 2; // Remplacez ... par la façon dont vous obtenez l'ID

    // Appelez la méthode de suppression de la classe ReclamationCrud
    ReclamationCrud reclamationCrud = new ReclamationCrud();
    reclamationCrud.supprimerReclamation(idReclamationASupprimer);
    }

    @FXML
    private void modifier(MouseEvent event) {
        int idReclamationAModifier = 7; // Remplacez ... par la façon dont vous obtenez l'ID

    // Récupérez les nouvelles valeurs à partir des champs de texte ou d'autres contrôles de l'interface utilisateur
    int userIdValue = Integer.parseInt(userId.getText());
    String descriptionValue = description_r.getText();
    LocalDate dateValue = date_rec.getValue();

    // Créez une instance de Reclamation avec les nouvelles valeurs
    Reclamation reclamation = new Reclamation();
    reclamation.setUserId(userIdValue);
    reclamation.setDescription(descriptionValue);
    reclamation.setDate(Date.from(dateValue.atStartOfDay(ZoneId.systemDefault()).toInstant()));

    // Appelez la méthode de modification de la classe ReclamationCrud
    ReclamationCrud reclamationCrud = new ReclamationCrud();
    reclamationCrud.modifierReclamation(idReclamationAModifier, descriptionValue);
    
    }

}

    
