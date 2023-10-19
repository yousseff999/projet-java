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
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class PageReclamationController implements Initializable {

    @FXML
    private TextField userid;
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
    @FXML
    private TableColumn<Reclamation, Integer> nom_col;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ShowReclamation();
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
    private void ajouter(MouseEvent event) throws SQLException {
        
        //String strId = userId.getText(); // Supposez que strId contient "123" (valeur en tant que chaîne de caractères)
        String id = userid.getText();
        LocalDate date=date_rec.getValue();
        String desc=description_r.getText();
       int reclamationId=0;
        
       
         int id_u; 
      if ((id.length()<1)|| (!id.matches("\\d+"))) {
     
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("id invalide ..!");
        Optional<ButtonType>result =  alert.showAndWait();     
      }
      
      else if (date==null){   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText(" date invalide ..!");
        Optional<ButtonType>result =  alert.showAndWait();    }
      else if  (desc.length()<1) {
     
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText(" description invalide ..!");
        Optional<ButtonType>result =  alert.showAndWait();     
      }
      
        else{
          id_u = Integer.parseInt(userid.getText());
           Reclamation r=new Reclamation(reclamationId,id_u,date,desc);
        bb.ajouterReclamation(r);
        ShowReclamation();
        }
        //bb.ShowReclamation(tab_rec, id_col, date_col, desc_col);
        
        
        
        
        
  /*  // Récupérez les valeurs des champs du formulaire
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
        try {
            reclamationCrud.ShowReclamation(tab_rec, id_col, date_col, desc_col);
        } catch (SQLException ex) {
            Logger.getLogger(PageReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }  


   @FXML
    private void supprimer(MouseEvent event) throws SQLException {
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Warning");
            alert.setContentText("Confirmation..!");
        Optional<ButtonType>result =  alert.showAndWait(); 
        if(result.get() == ButtonType.OK){
             Reclamation r= tab_rec.getSelectionModel().getSelectedItem();
             bb.supprimerReclamation(r.getReclamationId());
            ShowReclamation();}
        else {}
           
       
       
      
             
       

          

}
        
       
    

    @FXML
    private void modifier(MouseEvent event) {
        
        
                     Reclamation r= tab_rec.getSelectionModel().getSelectedItem();

        int idReclamationAModifier = r.getUserId(); // Remplacez ... par la façon dont vous obtenez l'ID

    // Récupérez les nouvelles valeurs à partir des champs de texte ou d'autres contrôles de l'interface utilisateur
  userid.setText(Integer.toString(r.getUserId()));
  date_rec.setValue(r.getDate());
  
      String desc=description_r.getText();
Reclamation r2=new Reclamation(r.getReclamationId(),r.getUserId(),r.getDate(),desc);
    // Appelez la méReclamationthode de modification de la classe ReclamationCrud
    ReclamationCrud rc=new ReclamationCrud();
     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Warning");
            alert.setContentText("Confirmation..!");
        Optional<ButtonType>result =  alert.showAndWait(); 
        if(result.get() == ButtonType.OK){
    rc.modifierReclamation(r2.getReclamationId(), desc);
        try {
            ShowReclamation();
        } catch (SQLException ex) {
            Logger.getLogger(PageReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else{}
    }
/*public void ShowReclamation (TableView<Reclamation> tab_rec, TableColumn<Reclamation, Integer> id_col, 
        TableColumn<Reclamation, String> date_col, TableColumn<Reclamation, String> desc_col) throws SQLException {
         
        
         ObservableList< Reclamation> Reclamationlist =getReclamationlist();        
         
        id_col.setCellValueFactory(new PropertyValueFactory<>("reclamationId"));
        date_col.setCellValueFactory(new PropertyValueFactory<>("date"));
        desc_col.setCellValueFactory(new PropertyValueFactory<>("description"));
       
        tab_rec.setItems(Reclamationlist);
}
         private ObservableList<Reclamation> getReclamationlist() throws SQLException {
           
   
     String query = "SELECT * FROM reclamation";
 
           
           pst = mc.getCnx().prepareStatement(query);
              ResultSet rs =pst.executeQuery(query);
             ObservableList<Reclamation> reclamationlist =FXCollections.observableArrayList();
            while (rs.next()){
              reclamationlist.add(new Reclamation(
    rs.getInt("reclamationId"),         ///id_a de DB
    rs.getInt("userID"),
    rs.getDate("date").toLocalDate(),
    rs.getString("description")
   

              ));                    
     } 
        return reclamationlist;
         

}*/
public void ShowReclamation() throws SQLException {
    try {
        String query = "SELECT * FROM reclamation"; // Remplacez "reclamation" par le nom de votre table
           pst = mc.getCnx().prepareStatement(query);
              ResultSet rs =pst.executeQuery(query);

        ObservableList<Reclamation> reclamationList = FXCollections.observableArrayList();
        while (rs.next()) {
            int id = rs.getInt("userId"); // Remplacez "id" par le nom de la colonne d'ID
            int idrec = rs.getInt("reclamationId");
            LocalDate date = rs.getDate("date").toLocalDate(); // Remplacez "date" par le nom de la colonne de date
            String description = rs.getString("description"); // Remplacez "description" par le nom de la colonne de description

            Reclamation reclamation = new Reclamation(idrec,id, date, description);
            reclamationList.add(reclamation);
        }

        // Associez les données aux colonnes de la table
        
        id_col.setCellValueFactory(new PropertyValueFactory<>("reclamationId"));
        nom_col.setCellValueFactory(new PropertyValueFactory<>("userId"));

        date_col.setCellValueFactory(new PropertyValueFactory<>("date"));
        desc_col.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Affichez les données dans la table
        tab_rec.setItems(reclamationList);

    } catch (SQLException ex) {
        System.err.println("Erreur lors de la récupération des réclamations : " + ex.getMessage());
    }
}
}

    
