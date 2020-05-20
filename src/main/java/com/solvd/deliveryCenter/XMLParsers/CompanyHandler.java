package com.solvd.deliveryCenter.XMLParsers;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.solvd.deliveryCenter.models.Company;
import com.solvd.deliveryCenter.models.Shop;

public class CompanyHandler extends DefaultHandler {
	
    private static final String COMPANIES = "companies";
    private static final String COMPANY = "company";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PHONENUMBER = "phoneNumber";
    private static final String EMAIL = "email";
    private static final String SHOPS = "shops";
    private static final String SHOP = "shop";
	private static final String SHOPID = "shopId";
	private static final String ADDRESS = "address";
    private static final String SHOPPHONENUMBER = "shopPhoneNumber";
	private static final String SHOPEMAIL = "shopemail";	
	   		 
    private ArrayList<Company> companies;
    private ArrayList<Shop> shops;
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
            case COMPANIES:
            	companies = new ArrayList<Company>();
                break;
            case COMPANY:
                companies.add(new Company());
                break;
            case SHOPS:
            	shops = new ArrayList<Shop>();
                break;
            case SHOP:
            	shops.add(new Shop());
            	Integer shopIndex = attr.getIndex(SHOPID);
            	if(shopIndex == -1) shops.get(shops.size()-1).setId(Long.valueOf(attr.getValue(shopIndex)));
            	shopIndex = attr.getIndex(ADDRESS);
            	if(shopIndex == -1) shops.get(shops.size()-1).setAddress(attr.getValue(shopIndex));
            	shopIndex = attr.getIndex(SHOPPHONENUMBER);
            	if(shopIndex == -1) shops.get(shops.size()-1).setPhoneNumber(attr.getValue(shopIndex));
            	shopIndex = attr.getIndex(SHOPEMAIL);
            	if(shopIndex == -1) shops.get(shops.size()-1).setEmail(attr.getValue(shopIndex));
        }
    }
 
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case ID:
            	companies.get(companies.size()-1).setId(Long.valueOf(elementValue));
            	break;
            case NAME:
            	companies.get(companies.size()-1).setName(elementValue);
            	break;
            case PHONENUMBER:
            	companies.get(companies.size()-1).setPhoneNumber(elementValue);
            	break;
            case EMAIL:
            	companies.get(companies.size()-1).setEmail(elementValue);
            	break;
            case SHOPS:
            	companies.get(companies.size()-1).setShops(shops);
        }
        
    }
 
    public ArrayList<Company> getCompanies() {
        return companies;
    }	

}
