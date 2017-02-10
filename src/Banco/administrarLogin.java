/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;
/**
 *
 * @author Laura B
 */

import java.io.IOException;
import java.util.logging.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;

public class administrarLogin {
    private Scene scene;

  public administrarLogin(Scene scene) {
    this.scene = scene;
  }
  
  public void autentificacion(String sessionID) {
    pantallaPrincipal(sessionID);
  }
  
  public void logout() {
    pantallaInicial();
  }
    
  public void pantallaInicial() {
    try {
      FXMLLoader loader = new FXMLLoader(
        getClass().getResource("Login.fxml")
      );
      scene.setRoot((Parent) loader.load());
      LoginController controller = loader.<LoginController>getController();
      controller.initManager(this);
    } catch (IOException ex) {
      Logger.getLogger(administrarLogin.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
    private void pantallaPrincipal(String sessionID) {
    try {
      FXMLLoader loader = new FXMLLoader(
        getClass().getResource("mainview.fxml")
      );
      scene.setRoot((Parent) loader.load());
      MainviewController controller = loader.<MainviewController>getController();
      controller.initSessionID(this, sessionID);
    } catch (IOException ex) {
      Logger.getLogger(administrarLogin.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
}
