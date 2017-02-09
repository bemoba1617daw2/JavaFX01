/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;
import AdmBanco.Cliente;
import AdmBanco.Cuenta;
import AdmBanco.Usuario;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Laura B
 */
public class Login extends Application {
    
  public static void main(String[] args) {
      launch(args); 
//     Cliente usuari3 = new Cliente("Laura","Bujalance",28,222222222,"clot","123");
//     Cuenta c3 = new Cuenta( 987654321, true, 2100, 1313,"clot" );

   
      
  }
  
  @Override 
  public void start(Stage stage) throws IOException {
    Scene scene = new Scene(new StackPane());
    
    administrarLogin admLogin = new administrarLogin(scene);
    admLogin.pantallaInicial();

    stage.setScene(scene);
    stage.show();
  }

}
