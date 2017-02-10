/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

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
      EntidadFinanciera Bancolacaixa = new EntidadFinanciera ("CaixaBank", "españa",2011);
      Cliente.entidades.add(Bancolacaixa);
      Cliente cliente1 = new Cliente("Bernat","Montoro",23,635486846,"12345678A","clot");
      Cliente cliente2 = new Cliente("Laura","Bujalance",19,623458746,"87654321B","clot1");
      Cliente cliente3 = new Cliente("Sergio","Martinez",22,675678555,"10234567C","clot2");
      ManageXML.actualitzarXML(cliente1);
      ManageXML.actualitzarXML(cliente2);
      ManageXML.actualitzarXML(cliente3);
      ManageXML.cargaDatosXML("clients.xml",Cuenta.clientes);
      //for (Cliente client : Cuenta.clientes)
            Cuenta.clientes.forEach((client) -> {
                System.out.println(client);
            }); 
      launch(args);  
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
