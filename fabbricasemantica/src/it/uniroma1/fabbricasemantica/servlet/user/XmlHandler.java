package it.uniroma1.fabbricasemantica.servlet.user;


import java.io.File;
import java.io.IOException;
import java.net.URL;

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
import org.xml.sax.SAXException;

public class XmlHandler {
	
	private  DocumentBuilderFactory docbuilfac;
	private  DocumentBuilder docbuil;
	private  Document doc;
	private  Element root;
	private URL file;
	
	
	public XmlHandler(URL file) {
		this.file=file;
	}
	
	/**
	 * 
	 * @return true if the opening file success 
	 */
	
	private boolean openFile() {
		docbuilfac = DocumentBuilderFactory.newInstance();
		try {
			docbuil = docbuilfac.newDocumentBuilder();
			doc = docbuil.parse(file.getPath());}
		catch(Exception e) {
			System.out.println("Error_XmlHandler: "+e.toString());
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param email user email
	 * @param password user password
	 * @return	true if the user's password and email is correct 
	 * @throws SAXException
	 * @throws IOException
	 */
	
	public boolean userEmailCheck(String email,String password){
		if(openFile()==false) {
			return false;
		}
		docbuilfac = DocumentBuilderFactory.newInstance();
		//System.out.println(file.getPath());
		root = doc.getDocumentElement(); //print user tag
		NodeList nl=root.getElementsByTagName("email"); //generate a list of email tags
		for(int i=0;i<nl.getLength();i++) {
			System.out.println("total users: "+nl.getLength());
			Node n = nl.item(i);// get email tag
			System.out.println(email+"="+n.getTextContent()); //print email tag's content
			//System.out.println(email+" "+password);
			if(n.getTextContent().equals(email)) { 
				//System.out.println(n.getNextSibling() instanceof Element);
				//System.out.println("xml handler pass");
				Node sibling = n.getNextSibling();
				if(sibling.getTextContent().equals(password)) return true;
				while (!(sibling instanceof Element) && sibling != null) {//keep going until we find the next sibling other wise end up getting whitespace
				    sibling = sibling.getNextSibling();
				    System.out.println(password+"="+sibling.getTextContent());
				    if(sibling.getTextContent().equals(password)) return true;
				}
			}
			//System.out.println(n.getTextContent()+"  "+n.getParentNode().getAttributes().getNamedItem("id").getTextContent());
		}
		return false;
		
	}
	/**
	 * 
	 * @param email user email
	 * @return true if the email already exist otherwise false
	 * @throws SAXException
	 * @throws IOException
	 */
	
	public boolean checkExistence(String email) {
		if(openFile()==false) {
			return false;
		}
		root = doc.getDocumentElement(); //print user tag
		//System.out.println(root);
		NodeList nl=root.getElementsByTagName("email"); //generate a list of email tags
		for(int i=0;i<nl.getLength();i++) {
			Node node= nl.item(i);
			System.out.println(node.getTextContent()+"=="+email);	
			if(node.getTextContent().equals(email))return true;
		}
		return false;
}
	/**
	 * 
	 * @param useremail user email address
	 * @param userpass user password
	 * @param nlang array of string that include user's native languages
	 * @param olang other languages that user can speak
	 * @throws SAXException
	 * @throws IOException
	 * @throws TransformerException
	 */
	public void writeToXml(String useremail,String userpass,String[] nlang,String...olang) {
		if(openFile()==false) {
			return ;
		}
		root = doc.getDocumentElement();
		Element user = doc.createElement("user");
		Element email=doc.createElement("email");
		email.setTextContent(useremail);
		Element password=doc.createElement("password");
		password.setTextContent(userpass);
		Element languages=doc.createElement("languages");
		Element nativelanguage=doc.createElement("native-languages");
		String lang = arrayToString(nlang);
		nativelanguage.setTextContent(lang);
		Element otherlanguages = doc.createElement("other-languages");
		String ol = arrayToString(olang);
		otherlanguages.setTextContent(ol);
		root.appendChild(user);
		user.appendChild(email);
		user.appendChild(password);
		languages.appendChild(nativelanguage);
		languages.appendChild(otherlanguages);
		user.appendChild(languages);
		
		try {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		//System.out.println("-----------Modified File-----------");
		StreamResult consoleResult = new StreamResult(new File(file.getPath()));
		transformer.transform(source, consoleResult);}
		catch(TransformerException e) {
			
		}
		
	}
	/**
	 * 
	 * @param ar array of Strings that include other languages
	 * @return	a String of other languages
	 */
	private String arrayToString(String[] ar) {
		String s="";
		int len=ar.length;
		for(int i=0;i<ar.length;i++) {
			if(i!=len-1){s+=ar[i]+",";}
			else {s+=ar[i];}
		}
		return s;
	}
	/**
	 * 
	 * @param node a tag of xml witch includes sub tags
	 * @return the last tag of given node
	 */
	private  Element getLastchild(Node node) {
        node = node.getLastChild();
        while (node != null && node.getNodeType() != Node.ELEMENT_NODE)
        {
            node = node.getPreviousSibling();
        }
        return (Element)node;
	}
	
	/**
	 * 
	 * @param node a tag of xml witch includes sub tags
	 * @return the first tag of given node
	 */
	private Element getFirstchild(Node node) {
        node = node.getFirstChild();
        while (node != null && node.getNodeType() != Node.ELEMENT_NODE)
        {
            node = node.getNextSibling();
        }
        return (Element)node;
	}
	
	/**
	 * 
	 * @param email user email address 
	 * @return	a array of string first String is native languages second String is other languages 
	 * @throws SAXException
	 * @throws IOException
	 */
	
	public String[] getLanguages(String email) {
		if(openFile()==false) {
			return null;
		}
		root = doc.getDocumentElement(); //print user tag
		//System.out.println(root);
		NodeList nl=root.getElementsByTagName("user"); //generate a list of email tags
		for(int i=0;i<nl.getLength();i++) {
			Node node= nl.item(i);
			if(getFirstchild(node).getTextContent().equals(email)) {
			String ss=getLastchild(node).getTextContent();
			String[] langs = ss.split(" ");
			return langs;		
			}
		}
		return null;
		
	}
	

}
