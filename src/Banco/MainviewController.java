package Banco;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Laura B
 */
public class MainviewController implements Initializable {
      @FXML private Button logoutButton;
      @FXML private Label  sessionLabel;  
      @FXML private TextField cantidad;
      @FXML private Button Ingresar;
      @FXML private MenuItem Sacar;
       @FXML private GridPane gridIngresar;
       
//       gridIngresar.opacity(0.0);
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
     public void initSessionID(final administrarLogin loginManager, String sessionID) {
    sessionLabel.setText("Bienvenido " + sessionID);
    logoutButton.setOnAction((ActionEvent event) -> {
        loginManager.logout();
    });
    Ingresar.setOnAction((ActionEvent event) -> {
        loginManager.logout();
    });
  }
     
     public void transacciones(){
         
         Sacar.setOnAction((ActionEvent event) -> {
            
    });
     }
    
}
