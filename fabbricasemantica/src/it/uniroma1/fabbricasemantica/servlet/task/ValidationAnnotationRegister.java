package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import it.uniroma1.fabbricasemantica.data.StandardTask;


public class ValidationAnnotationRegister {
	
	private  DocumentBuilderFactory docbuilfac;
	private  DocumentBuilder docbuil;
	private  Document doc;
	private  Element root;
	private String file;
	
	public ValidationAnnotationRegister(String file) {
		this.file=file;
	}
	
	private boolean openFile() {
		docbuilfac = DocumentBuilderFactory.newInstance();
		try {
			docbuil = docbuilfac.newDocumentBuilder();
			doc = docbuil.parse(file);}
		catch(Exception e) {
			System.out.println("Error_ValidationAnnotationRegister: "+e.toString());
			return false;
		}
		return true;
	}
	
	public boolean WriteXMl(String useremail,StandardTask task,String question,List<String> answer) throws TransformerException {
		if(openFile()==false) {
			return false;
		}
		createNewUser(useremail);
		root = doc.getDocumentElement();
		NodeList users = root.getElementsByTagName("user");
		for(int i=0;i<users.getLength();i++) {
			if(users.item(i).getAttributes().getNamedItem("email").getNodeValue().equals(useremail)) {
				Node xuser = users.item(i);
				NodeList childnodes=xuser.getChildNodes();
				for(int j=0;j<childnodes.getLength();j++) {
					Node node = childnodes.item(j);
					if(task.toString().equals(node.getNodeName())) {
						Element asked = doc.createElement("question-answer");
						asked.setTextContent(question+"-"+answer.toString());
						node.appendChild(asked);
					}
				}
			}
		}
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(doc);
	    StreamResult consoleResult = new StreamResult(new File(file));
	    transformer.transform(source, consoleResult);
	    return true;
		
	}
	/**
	 * 
	 * @param useremail for create a new useremail basic xml tag
	 * @return false if given useremail present otherwise return true and create basic xml tags
	 * @throws TransformerException
	 */
	private boolean createNewUser(String useremail) throws TransformerException {
		if(openFile()==false) {
			return false;
		}
		root = doc.getDocumentElement();
		NodeList users = root.getElementsByTagName("user");
		for(int i=0;i<users.getLength();i++) {
			if(users.item(i).getAttributes().getNamedItem("email").getNodeValue().equals(useremail)) return false;
		}
		Element user = doc.createElement("user");
		user.setAttribute("email", useremail);
			Arrays.asList(StandardTask.values()).forEach(data->{
			Element task = doc.createElement(data.toString());
			//task.setTextContent(" ");
			user.appendChild(task);
		});
		root.appendChild(user);
		
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        //System.out.println("-----------Modified File-----------");
        StreamResult consoleResult = new StreamResult(new File(file));
        transformer.transform(source, consoleResult);		
		return true;
	}
	/**public static void main(String[] args) throws SAXException, IOException, TransformerException {
		
		ValidationAnnotationRegister var = new ValidationAnnotationRegister("D:\\fabbricasemantica\\WebContent\\WEB-INF\\xml\\userValidationAnnotation.xml");
		var.WriteXMl("nijat123@gmail.com", StandardTask.TRANSLATION_VALIDATION, "fruit",Arrays.asList("miwe","frutta"));
	}*/
}
