package Banco;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
 @FXML private Label mensajeConexion;
 @FXML private CheckBox valdiationUsuarioLogin;
 @FXML private CheckBox valdiationEmpleadoLogin;
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
    /////////////////////////////////////////////////////////////////
        // Start --> Socols  
        //Traduccion direccion por IP
        String hostEntidad = "www.lacaixa.es";
        String SERVER_ADDRESS = "";
        Integer TCP_SERVER_PORT = 80;    
        try {
            InetAddress ipaddress = InetAddress.getByName(hostEntidad);
            SERVER_ADDRESS = ipaddress.getHostAddress();
            mensajeConexion.setText("Conexión Establecida");
        } catch ( UnknownHostException e ) {
            System.out.println("Error al establecer conexión");
            mensajeConexion.setText("Error al establecer conexión");

        }   
        //Check Connection     
        System.out.println(hostAvailabilityCheck(SERVER_ADDRESS, TCP_SERVER_PORT ));
        // End --> Socols 
        /////////////////////////////////////////////////////////////////
        System.out.println(valdiationUsuarioLogin.isSelected());
        
        if(hostAvailabilityCheck(SERVER_ADDRESS, TCP_SERVER_PORT )){
            loginButton.setOnAction((ActionEvent event) -> {
                boolean sessionID1 = autorizar();
                //boolean sessionID1Empleado = autorizarEmpleado();
                String sessionID2 = generateSessionID();        
                if (sessionID1 == false && valdiationUsuarioLogin.isSelected()==true) {
                       admLogin.autentificacion(sessionID2);
                       //admLogin.autentificacionEmpleado(sessionID2);

                }else if(sessionID1 == true){
                    messageLoginFx.setText("Usuario o Contraseña Incorrectos!");
                }  
                
               /* if (sessionID1 == false && valdiationEmpleadoLogin.isSelected()==false) {
                       admLogin.autentificacionEmpleado(sessionID2);

                }else if(sessionID1 == true){
                    messageLoginFx.setText("Usuario o Contraseña Incorrectos!");
                }*/    

            });
        }
  }

private boolean autorizar() {
    boolean noexisteusuario=true;
    for(int z=0;z<Cuenta.clientes.size();z++) {
       if(Cuenta.clientes.get(z).getNIF().equals(user.getText()) && Cuenta.clientes.get(z).getPassword().equals(password.getText())){
           noexisteusuario=false;
           break;
       }else{
           noexisteusuario=true;
       }
    }
     return noexisteusuario;
}

/*private boolean autorizarEmpleado() {
    boolean noexisteusuario=true;
  
       if("1234".equals(user.getText()) && "456".equals(password.getText())){
           noexisteusuario=false;
           
       }else{
           noexisteusuario=true;
       }
    
     return noexisteusuario;
}*/

  private String generateSessionID() {
//    sessionID++;
    return (user.getText());
  }
  
  public static boolean hostAvailabilityCheck(String SERVER_ADDRESS, Integer TCP_SERVER_PORT ) { 
           try (Socket s = new Socket(SERVER_ADDRESS, TCP_SERVER_PORT)) {
               return true;
           } catch (IOException ex) {        
           }
           return false;
    } 
}
