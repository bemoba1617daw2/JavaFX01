package Banco;

import java.util.*;
import java.util.Scanner;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * Classe que crea i escriu un document XML mitjançant JAXP i API DOM
 * @author sergi grau
 * @version 1.0 11/02/2014
 */ 
public class ManageXML {
           public static void cargaDatosXMLCliente(String cadena, ArrayList<Cliente> array){ 
               // esta funcion instancia objetos de los clientes que estan en el XML
               // el parametro cadena es el nombre del fichero del qual se quiere leer
               try {
            File fichero = new File(cadena);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fichero);
            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("Cliente");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nombreXML = obtenirContingut("Nombre", element);
                    String apellidosXML = obtenirContingut("Apellidos", element);
                    int edadXML = Integer.parseInt(obtenirContingut("Edad", element));
                    int telefonoXML = Integer.parseInt(obtenirContingut("Teléfono", element));
                    String NIFXML = obtenirContingut("NIF", element);
                    String passwordXML = obtenirContingut("Password", element);
                    Cliente client = new Cliente(nombreXML, apellidosXML, edadXML, telefonoXML, NIFXML, passwordXML);
                    if (!array.contains(client)){
                        array.add(client);                        
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
           }
           public static void actualitzarXMLCliente(Cliente Client) {
                        try {
                            // esta funcion añade un cliente al xml
                String nombreXML = Client.getNombre();
                String apellidosXML = Client.getApellidos();
                String edadXML = Integer.toString(Client.getEdad());
                String telefonoXML = Integer.toString(Client.getTelefono());
                String NIFXML = Client.getNIF();
                String passwordXML = Client.getPassword();
         
                              
                File clients = new File ("clients.xml");
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                
                Document nodeDocument = docBuilder.parse(clients);
                Element elementArrel = nodeDocument.getDocumentElement();
                
		Element cliente = nodeDocument.createElement("Cliente");
		elementArrel.appendChild(cliente);
 
		Element nombre = nodeDocument.createElement("Nombre");
		nombre.appendChild(nodeDocument.createTextNode(nombreXML));
		cliente.appendChild(nombre);
 
		Element apellidos = nodeDocument.createElement("Apellidos");
		apellidos.appendChild(nodeDocument.createTextNode(apellidosXML));
		cliente.appendChild(apellidos);
                
                Element edad = nodeDocument.createElement("Edad");
		edad.appendChild(nodeDocument.createTextNode(edadXML));
		cliente.appendChild(edad);
                
                Element telefono = nodeDocument.createElement("Teléfono");
		telefono.appendChild(nodeDocument.createTextNode(telefonoXML));
		cliente.appendChild(telefono);
                
                Element NIF = nodeDocument.createElement("NIF");
		NIF.appendChild(nodeDocument.createTextNode(NIFXML));
		cliente.appendChild(NIF);
                
		Element password = nodeDocument.createElement("Password");
		password.appendChild(nodeDocument.createTextNode(passwordXML));
		cliente.appendChild(password);
 
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource origen = new DOMSource(nodeDocument);
		StreamResult sortidaXML = new StreamResult(new File("clients.xml"));
 
		
		transformer.transform(origen, sortidaXML);
 
		System.out.println("Desat!");
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  } catch (SAXException ex) {
                Logger.getLogger(ManageXML.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ManageXML.class.getName()).log(Level.SEVERE, null, ex);
            }
            
          
	  
	}
            
          public static void cargaDatosXMLEmpleado(String cadena, HashMap empleado){ 
               // esta funcion instancia objetos de los clientes que estan en el XML
               // el parametro cadena es el nombre del fichero del qual se quiere leer
               try {
            File fichero = new File(cadena);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fichero);
            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("Empleado");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String codiXML = (obtenirContingut("CodiEmpleado", element));
                    String nombreXML = obtenirContingut("Username", element);
                    String nifXML = (obtenirContingut("NIF", element));
                    String passwordXML = obtenirContingut("Password", element);
//                    Cliente client = new Cliente(nombreXML, apellidosXML, edadXML, telefonoXML, NIFXML, passwordXML);
                     Empleado empleat = new Empleado(codiXML,nombreXML,nifXML,passwordXML);
                     empleat.put(nombreXML,passwordXML);                        
                    
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
           }
//	public static void main(String argv[]) {
//              Cliente cliente1 = new Cliente("Bernat","Montoro",23,635486846,"47926215B","admin123");
//              Cliente cliente2 = new Cliente("Joan","Claver",23,635486846,"47926215B","admin123");
//              Cliente cliente3 = new Cliente("Robert","Andrea",23,635486846,"47926215B","admin123");
//              ArrayList<Cliente> Clientes = new ArrayList();
//              
//              cargaDatosXML("clients.xml",Clientes);
//              for (Cliente client : Clientes){
//                System.out.println(client);
//              } 	  
//	} 
        
                public static void actualitzarXMLEmpleado(Empleado Empleat) {
                        try {
                            // esta funcion añade un cliente al xml
                String codiXML = Empleat.getCodiEmpleado();
                String nombreXML = Empleat.getUsername();
                String NIFXML = Empleat.getNIF();
                String passwordXML = Empleat.getPassword();
         
                              
                File empleats = new File ("empleats.xml");
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                
                Document nodeDocument = docBuilder.parse(empleats);
                Element elementArrel = nodeDocument.getDocumentElement();
                
		Element cliente = nodeDocument.createElement("Empleado");
		elementArrel.appendChild(cliente);
 
		Element nombre = nodeDocument.createElement("CodiEmpleado");
		nombre.appendChild(nodeDocument.createTextNode(codiXML));
		cliente.appendChild(nombre);
 
		Element apellidos = nodeDocument.createElement("Username");
		apellidos.appendChild(nodeDocument.createTextNode(nombreXML));
		cliente.appendChild(apellidos);
                
                Element edad = nodeDocument.createElement("NIF");
		edad.appendChild(nodeDocument.createTextNode(NIFXML));
		cliente.appendChild(edad);
                
                Element telefono = nodeDocument.createElement("Password");
		telefono.appendChild(nodeDocument.createTextNode(passwordXML));
		cliente.appendChild(telefono);
 
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource origen = new DOMSource(nodeDocument);
		StreamResult sortidaXML = new StreamResult(new File("empleats.xml"));
 
		
		transformer.transform(origen, sortidaXML);
 
		System.out.println("Desat!");
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  } catch (SAXException ex) {
                Logger.getLogger(ManageXML.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ManageXML.class.getName()).log(Level.SEVERE, null, ex);
            }
            
          
	  
	}
        private static String obtenirContingut(String etiqueta, Element element) {
        NodeList nodes = element.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }
}