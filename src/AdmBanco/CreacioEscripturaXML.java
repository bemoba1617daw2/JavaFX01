import java.util.*;
import java.util.Scanner;

import java.io.File;
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
/**
 * Classe que crea i escriu un document XML mitjançant JAXP i API DOM
 * @author sergi grau
 * @version 1.0 11/02/2014
 */ 
public class CreacioEscripturaXML {
 
	public static void main(String argv[]) {
 
	  try {
              
                Scanner entrada = new Scanner(System.in);
                System.out.print("User: ");
                String userXML = entrada.nextLine();
                System.out.print("Pass: ");
                String passXML = entrada.nextLine();
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		Document nodeDocument = docBuilder.newDocument();
		Element elementArrel = nodeDocument.createElement("LA_CAIXA");
		nodeDocument.appendChild(elementArrel);
 
		Element treballador = nodeDocument.createElement("cliente");
		elementArrel.appendChild(treballador);
 
		treballador.setAttribute("id", "1");
 
		Element user = nodeDocument.createElement("user");
		user.appendChild(nodeDocument.createTextNode(userXML));
		treballador.appendChild(user);
 
		Element pass = nodeDocument.createElement("pass");
		pass.appendChild(nodeDocument.createTextNode(passXML));
		treballador.appendChild(pass);

 
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource origen = new DOMSource(nodeDocument);
		StreamResult sortidaXML = new StreamResult(new File("BD_EntidadBancaria.xml"));
 
		
		transformer.transform(origen, sortidaXML);
 
		System.out.println("Desat!");
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}