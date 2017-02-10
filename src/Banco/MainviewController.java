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
import javafx.scene.control.Menu;
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
      @FXML private TextField cantidadIngresar;
      @FXML private TextField cantidadRetirar;
      @FXML private Button ingresarDinero;
      @FXML private Button retirarDinero;
      @FXML private MenuItem Ingresar;
      @FXML private GridPane gridIngresar;
      @FXML private Label  saldoIngresar;  
      @FXML private Label  saldoRetirar; 
      @FXML private Menu inicio; 
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
   gridIngresar.setVisible(false);
    sessionLabel.setText("Bienvenido " + sessionID);
    logoutButton.setOnAction((ActionEvent event) -> {
        loginManager.logout();
    });
    ingresarDinero.setOnAction((ActionEvent event) -> {
        for(int z=0;z<Cliente.cuentas.size();z++) {
                 if(Cliente.cuentas.get(z).getNIF().equals(sessionID)){
                       Cliente.cuentas.get(z).Ingresar(Float.parseFloat(cantidadIngresar.getText()));
                       System.out.println("Actualizacion estado de la cuenta: "+Cliente.cuentas.get(z).getNumerocuenta());
                        System.out.println("Su saldo actual es de : "+Cliente.cuentas.get(z).getSaldo());
                        DetallesOperaciones detalles = new DetallesOperaciones(sessionID,Cliente.cuentas.get(z).getNumerocuenta(),Float.parseFloat(cantidadIngresar.getText()),Cliente.cuentas.get(z).VerSaldo(),"Ingresar", Fecha.getFechaActual());
                        DetallesOperaciones.detalles.add(detalles);
                        saldoIngresar.setText("Su saldo actual es de: "+Cliente.cuentas.get(z).getSaldo());
                 }
        }

    });
    
//    retirarDinero.setOnAction((ActionEvent event) -> {
//          for(int z=0;z<Cliente.cuentas.size();z++) {
//                 if(Cliente.cuentas.get(z).getNIF().equals(sessionID)){
//                       Cliente.cuentas.get(z).Retirar(Float.parseFloat(cantidadRetirar.getText()));
//                       System.out.println("Actualizacion estado de la cuenta: "+Cliente.cuentas.get(z).getNumerocuenta());
//                        System.out.println("Su saldo actual es de : "+Cliente.cuentas.get(z).getSaldo());
//                        DetallesOperaciones detalles = new DetallesOperaciones(sessionID,Cliente.cuentas.get(z).getNumerocuenta(),Float.parseFloat(cantidadRetirar.getText()),Cliente.cuentas.get(z).VerSaldo(),"Retirar", Fecha.getFechaActual());
//                        DetallesOperaciones.detalles.add(detalles);
//                        saldoRetirar.setText("Su saldo actual es de: "+Cliente.cuentas.get(z).getSaldo());
//                 }
//        }
//    });
     retirarDinero.setOnAction((ActionEvent event) -> {
            gridIngresar.setVisible(true);
     });
  }
     
  
    
}
