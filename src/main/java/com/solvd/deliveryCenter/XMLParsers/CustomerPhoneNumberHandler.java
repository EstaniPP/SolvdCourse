package com.solvd.deliveryCenter.XMLParsers;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.solvd.deliveryCenter.models.CustomerPhoneNumber;

public class CustomerPhoneNumberHandler extends DefaultHandler {
	
    private static final String PHONES = "phones";
    private static final String PHONE = "phone";
    private static final String ID = "id";
    private static final String CUSTOMERID = "customerId";
    private static final String PHONENUMBER = "phoneNumber";	
	   		 
    private ArrayList<CustomerPhoneNumber> phones;
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
            case PHONES:
            	phones = new ArrayList<CustomerPhoneNumber>();
                break;
            case PHONE:
                phones.add(new CustomerPhoneNumber());
                break;
        }
    }
 
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case ID:
            	phones.get(phones.size()-1).setId(Long.valueOf(elementValue));
            	break;
            case PHONENUMBER:
            	phones.get(phones.size()-1).setPhoneNumber(elementValue);
            	break;
            case CUSTOMERID:
            	phones.get(phones.size()-1).setCustomerId(Long.valueOf(elementValue));
        }
        
    }
 
    public ArrayList<CustomerPhoneNumber> getCustomerPhoneNumbers() {
        return phones;
    }	

}
