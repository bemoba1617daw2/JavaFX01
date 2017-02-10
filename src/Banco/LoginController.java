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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Laura B
 */
public class LoginController implements Initializable {
 @FXML private TextField user;
  @FXML private TextField password;
  @FXML private Button loginButton;
   @FXML private Label messageLoginFx;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

public void initManager(final administrarLogin admLogin) {
    loginButton.setOnAction((ActionEvent event) -> {
        boolean sessionID1 = autorizar();
        String sessionID2 = generateSessionID();
        if (sessionID1 == false) {
               admLogin.autentificacion(sessionID2);
        }else if(sessionID1 == true){
            messageLoginFx.setText("Usuario o Contraseña Incorrectos!");
        }
            //messageLoginFx.setText("Usuario o Contraseña Incorrectos!");
        
    });
  }

private boolean autorizar() {
    boolean noexisteusuario=true;
    for(int z=0;z<Cuenta.clientes.size();z++) {
       if(Cuenta.clientes.get(z).getNIF().equals(user.getText()) && Cuenta.clientes.get(z).getPassword().equals(password.getText())){
           noexisteusuario=false;
       }else{
           noexisteusuario=true;
       }
    }
     return noexisteusuario;
}
    
    
//    return 
//      "clot".equals(user.getText()) && "123".equals(password.getText()) 
//            ? generateSessionID() 
//            : null;
  
  
//  private static int sessionID = 0;

  private String generateSessionID() {
//    sessionID++;
    return (user.getText());
  }
    
}
