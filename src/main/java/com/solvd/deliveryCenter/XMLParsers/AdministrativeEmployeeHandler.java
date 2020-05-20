package com.solvd.deliveryCenter.XMLParsers;

import java.sql.Time;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.solvd.deliveryCenter.models.AdministrativeEmployee;
import com.solvd.deliveryCenter.models.EmployeeHour;

public class AdministrativeEmployeeHandler extends DefaultHandler {
	
    private static final String ADMINISTRATIVEEMPLOYEES = "administrativeemployees";
    private static final String ADMINISTRATIVEEMPLOYEE = "administrativeemployee";
    private static final String EMPLOYEEID = "employeeId";
    private static final String SALARY = "salary";
    private static final String SCHEDULE = "schedule";
    private static final String EMPLOYEEHOUR = "employeeHour";
	private static final String HOURID = "id";
    private static final String HOUR = "hour";
    private static final String DAY = "day";	
	   		 
    private ArrayList<AdministrativeEmployee> employess;
    private ArrayList<EmployeeHour> schedule;
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
            case ADMINISTRATIVEEMPLOYEES:
            	employess = new ArrayList<AdministrativeEmployee>();
                break;
            case ADMINISTRATIVEEMPLOYEE:
                employess.add(new AdministrativeEmployee());
                break;
            case SCHEDULE:
            	schedule = new ArrayList<EmployeeHour>();
                break;
            case EMPLOYEEHOUR:
            	schedule.add(new EmployeeHour());
            	Integer index = attr.getIndex(HOURID);
            	if(index == -1) schedule.get(schedule.size()-1).setId(Long.valueOf(attr.getValue(index)));
            	index = attr.getIndex(EMPLOYEEID);
            	if(index == -1) schedule.get(schedule.size()-1).setEmployeeId(Long.valueOf(attr.getValue(index)));
            	index = attr.getIndex(HOUR);
            	if(index == -1) schedule.get(schedule.size()-1).setHour(Time.valueOf(attr.getValue(index)));
            	index = attr.getIndex(DAY);
            	if(index == -1) schedule.get(schedule.size()-1).setDay(attr.getValue(index));
        }
    }
 
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case EMPLOYEEID:
            	employess.get(employess.size()-1).setEmployeeId(Long.valueOf(elementValue));
            	break;
            case SALARY:
            	employess.get(employess.size()-1).setSalary(Double.valueOf(elementValue));
            	break;
            case SCHEDULE:
            	employess.get(employess.size()-1).setSchedule(schedule);
        }
        
    }
 
    public ArrayList<AdministrativeEmployee> getAdministrativeEmployees() {
        return employess;
    }	

}
