package com.company.controllers;

import java.io.File;
import java.sql.Date;
import java.util.List;

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


import com.company.entity.Car;
import com.company.entity.ClassOfCar;
import com.company.entity.Insurance;
import com.company.entity.License;
import com.company.entity.Person;

public class Xml {
	private CarController controller;
	private InsuranceController icontroller;
	public Xml(CarController controller, InsuranceController icontroller) {
		this.controller = controller;
		this.icontroller = icontroller;
	}
	public void createXml(String file, List<Car> cars) {
		 try {
			 
	            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance(); // documentfactory
	 
	            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder(); // documenybuilder
	 
	            Document document = documentBuilder.newDocument(); // create a new document xml
	 
	           	           
	            
	            Element root = document.createElement("inform"); 
	            document.appendChild(root); 
	             
	            for(Car car: cars) {
	            	Person person = this.controller.getPerson(car.getPersonId()); 
	            	if(Utils.DateToInt(person.getDateOfBirth()) >= 18) {
	            		
	            	Element first = document.createElement("car"); 
		            root.appendChild(first); 
	 
	           
	            System.out.println(person.toString()); 
	    
	            ClassOfCar classofcar = this.controller.getClassOfCar(car.getCarClassId());
	            License license = this.controller.getLicense(person.getId());
	            Element carnumber = document.createElement("carnumber"); 
	            carnumber.appendChild(document.createTextNode(car.getNumber())); 
	            first.appendChild(carnumber); 
	            
	            Element carclass = document.createElement("car_class"); 
	            carclass.appendChild(document.createTextNode(classofcar.getC() + "")); 
	            first.appendChild(carclass); 
	            
	            Element firstname = document.createElement("firstname"); 
	            firstname.appendChild(document.createTextNode(person.getFirstName())); 
	            first.appendChild(firstname); 
	 
	          
	            Element lastname = document.createElement("lastname"); 
	            lastname.appendChild(document.createTextNode(person.getLastName())); 
	            first.appendChild(lastname); 
	 
	        
	            Element dateofbirth = document.createElement("dateofbirth"); 
	            dateofbirth.appendChild(document.createTextNode(person.getDateOfBirth().toString()));
	            first.appendChild(dateofbirth);
	            
	            Element givendate = document.createElement("givendate"); 
	            givendate.appendChild(document.createTextNode(license.getGivenDate().toString()));
	            first.appendChild(givendate);
	            
	            Element experience = document.createElement("experience");
	            experience.appendChild(document.createTextNode(Utils.DateToInt(license.getGivenDate()) + "")); 
	            first.appendChild(experience); 
	            
	            TransformerFactory transformerFactory = TransformerFactory.newInstance(); 
	            Transformer transformer = transformerFactory.newTransformer(); 
	            DOMSource domSource = new DOMSource(document); 
	            
	            	StreamResult streamResult = new StreamResult(new File(file)); 
	            	transformer.transform(domSource, streamResult); 
	            } else {
	            	System.out.println("Wrong person with id: " + person.getId() + ", not have a 18 years");
	            }
	            }
	            	System.out.println("Sucsessful!"); 
	           
	        } catch (ParserConfigurationException pce) {
	            pce.printStackTrace();
	        } catch (TransformerException tfe) {
	            tfe.printStackTrace();
	        }
	    }
	
	
	
	
	public void readFromXml(String filename) {
		try   
		{
			int index = 0;
	
		File file = new File(filename);  
 
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
 
		DocumentBuilder db = dbf.newDocumentBuilder();  
		Document doc = db.parse(file);  
		doc.getDocumentElement().normalize();  
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); // Root element 
		
		NodeList nodeList = doc.getElementsByTagName("car");  
		for (int itr = 0; itr < nodeList.getLength(); itr++)   
		{  
		Node node = nodeList.item(itr);  // add nodelist
		System.out.println("name :" + node.getNodeName()); // output node names  
		if (node.getNodeType() == Node.ELEMENT_NODE) // if this node element  
		{  
		Element eElement = (Element) node;   // created a node
		    Integer id = this.icontroller.getIdOfPerson(eElement.getElementsByTagName("carnumber").item(0).getTextContent());
		    Person person = this.controller.getPerson(id);
		    Integer experience = Integer.parseInt(eElement.getElementsByTagName("experience").item(0).getTextContent());
		    Date date = new Date(System.currentTimeMillis());
		    date.setYear(date.getYear() + 1);
		    Insurance insurance = new Insurance(index, person.getFirstName(), person.getLastName(), Utils.DateToInt(person.getDateOfBirth()), 
		    		eElement.getElementsByTagName("car_class").item(0).getTextContent(), 
		    		Utils.calculateInsurancePrice(experience, this.icontroller.getCarClass(person.getId())), new Date(System.currentTimeMillis()), date,
		    		eElement.getElementsByTagName("carnumber").item(0).getTextContent());
		  
		    this.icontroller.addInsurance(insurance);
		    System.out.println("Insurance has been added!");
		    System.out.println(insurance.toString());
	
		    
		    		
		    		index++; // index our ID's
		    
		}  
		}  
		}   
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}  
		}  
}
