import java.util.*;
import java.util.Scanner;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * @author Martinez Sergio
 */ 
public class LecturaXMLDOM {

    public static void main(String args[]) {
        try {

            File Banco = new File("BD_EntidadBancaria.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(Banco);
            doc.getDocumentElement().normalize();
                  
            Scanner entrada = new Scanner(System.in);
            System.out.print("User: ");
            String user = entrada.nextLine();
            System.out.print("Pass: ");
            String pass = entrada.nextLine();
            
            System.out.println("***********");
            System.out.println("Entidad Bancaria " + doc.getDocumentElement().getNodeName());
            NodeList nodes = doc.getElementsByTagName("cliente");
            System.out.println("***********");                      

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;                  
                        //System.out.println("User: " + obtenirContingut("user", element));
                        //System.out.println("Pass: " + obtenirContingut("pass", element));
                        String userXML =  obtenirContingut("user", element);
                        String passXML =  obtenirContingut("pass", element);
                        
                   if(pass.equals(passXML) && user.equals(userXML)){
                       System.out.println("Estas Registrado");
                       accesoLogin();
                       break;
                       
                   } else System.out.println("No estas Registrado");

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String obtenirContingut(String etiqueta, Element element) {
        NodeList nodes = element.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }
    
    public  static void   accesoLogin() {
        System.out.println("Bienvenido");
    }
    
}