package com.solvd.deliveryCenter.XMLParsers;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.solvd.deliveryCenter.models.Department;
import com.solvd.deliveryCenter.models.Vehicle;

public class DepartmentHandler extends DefaultHandler {
	
	    private static final String DEPARTMENTS = "departments";
	    private static final String DEPARTMENT = "department";
	    private static final String ID = "id";
	    private static final String ESPECIALIZATION = "especialization";
	    private static final String ADDRESS = "address";
	    private static final String PHONENUMBER = "phoneNumber";
	    private static final String EMAIL = "email";
	    private static final String CEOID = "ceoId";
	    private static final String VEHICLES = "vehicles";
	    private static final String VEHICLE = "vehicle";
		private static final String VEHICLEID = "vehicleid";
		private static final String PLATE = "plate";
		private static final String MODEL = "model";
		private static final String YEAR = "year";
		   		 
	    private ArrayList<Department> departments;
	    private ArrayList<Vehicle> vehicles;
	    private String elementValue;
	    
	 
	    @Override
	    public void characters(char[] ch, int start, int length) throws SAXException {
	        elementValue = new String(ch, start, length);
	    }
	 
	    @Override
	    public void startDocument() throws SAXException {

	    }
	 
	    @Override
	    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
	        switch (qName) {
	            case DEPARTMENTS:
	            	departments = new ArrayList<Department>();
	                break;
	            case DEPARTMENT:
	                departments.add(new Department());
	                break;
	            case VEHICLES:
	            	vehicles = new ArrayList<Vehicle>();
	                break;
	            case VEHICLE:
	            	vehicles.add(new Vehicle());
	            	for(int i=0; i <attr.getLength(); i++) {
	            		if(attr.getQName(0).equals("departmentId"))
	            			vehicles.get(vehicles.size()-1).setDepartmentId(Long.valueOf(attr.getValue(0)));
	            	}
	        }
	    }
	 
	    @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException {
	        switch (qName) {
	            case ID:
	            	departments.get(departments.size()-1).setId(Long.valueOf(elementValue));
	            	break;
	            case ESPECIALIZATION:
	            	departments.get(departments.size()-1).setEspecialization(elementValue);
	            	break;
	            case ADDRESS:
	            	departments.get(departments.size()-1).setAddress(elementValue);
	            	break;
	            case PHONENUMBER:
	            	departments.get(departments.size()-1).setPhoneNumber(elementValue);
	            	break;
	            case EMAIL:
	            	departments.get(departments.size()-1).setEmail(elementValue);
	            	break;
	            case CEOID:
	            	departments.get(departments.size()-1).setCeoId(Long.valueOf(elementValue));
	            	break;
	            case VEHICLEID:
	            	vehicles.get(vehicles.size()-1).setId(Long.valueOf(elementValue));
	            	break;
	            case PLATE:
	            	vehicles.get(vehicles.size()-1).setPlate(elementValue);
	            	break;
	            case MODEL:
	            	vehicles.get(vehicles.size()-1).setModel(elementValue);
	            	break;
	            case YEAR:
	            	vehicles.get(vehicles.size()-1).setYear(Integer.valueOf(elementValue));
	            	break;
	            case VEHICLES:
	            	departments.get(departments.size()-1).setVehicles(vehicles);
	        }
	        
	    }
	 
	    public ArrayList<Department> getDepartments() {
	        return departments;
	    }	
	
}
