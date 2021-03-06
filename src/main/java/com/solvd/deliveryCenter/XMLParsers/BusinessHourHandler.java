package com.solvd.deliveryCenter.XMLParsers;

import java.sql.Time;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.solvd.deliveryCenter.models.BusinessHour;
import com.solvd.deliveryCenter.models.Company;
import com.solvd.deliveryCenter.models.Shop;

public class BusinessHourHandler  extends DefaultHandler {
	
    private static final String BUSINESSHOURS = "businessHours";
    private static final String BUSINESSHOUR = "businessHour";
    private static final String ID = "id";
    private static final String HOUR = "hour";
    private static final String DAY = "day";
    private static final String SHOP = "shop";
	private static final String SHOPID = "shopId";
	private static final String ADDRESS = "address";
    private static final String SHOPPHONENUMBER = "shopPhoneNumber";
	private static final String SHOPEMAIL = "shopEmail";		
	private static final String COMPANYID = "companyId";
	private static final String COMPANYNAME = "companyName";
	private static final String COMPANYPHONENUMBER = "companyPhoneNumber";
	private static final String COMPANYEMAIL = "companyEmail";
	private static final String COMPANY = "company";
	   		 
    private ArrayList<BusinessHour> hours;
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
            case BUSINESSHOURS:
            	hours = new ArrayList<BusinessHour>();
                break;
            case BUSINESSHOUR:
                hours.add(new BusinessHour());
                break;
            case SHOP:
            	hours.get(hours.size()-1).setShop(new Shop());
            	Integer shopIndex = attr.getIndex(SHOPID);
            	if(shopIndex == -1) hours.get(hours.size()-1).getShop().setId(Long.valueOf(attr.getValue(shopIndex)));
            	shopIndex = attr.getIndex(ADDRESS);
            	if(shopIndex == -1) hours.get(hours.size()-1).getShop().setAddress(attr.getValue(shopIndex));
            	shopIndex = attr.getIndex(SHOPPHONENUMBER);
            	if(shopIndex == -1) hours.get(hours.size()-1).getShop().setPhoneNumber(attr.getValue(shopIndex));
            	shopIndex = attr.getIndex(SHOPEMAIL);
            	if(shopIndex == -1) hours.get(hours.size()-1).getShop().setEmail(attr.getValue(shopIndex));
            	break;
            case COMPANY:
            	hours.get(hours.size()-1).getShop().setCompany(new Company());
            	break;
        }
    }
 
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case ID:
            	hours.get(hours.size()-1).setId(Long.valueOf(elementValue));
            	break;
            case HOUR:
            	hours.get(hours.size()-1).setHour(Time.valueOf(elementValue));
            	break;
            case DAY:
            	hours.get(hours.size()-1).setDay(elementValue);
            	break;
            case SHOPID:
            	hours.get(hours.size()-1).setShopId(Long.valueOf(elementValue));
            	break;
            case COMPANYID:
            	hours.get(hours.size()-1).getShop().getCompany().setId(Long.valueOf(elementValue));
            	break;
            case COMPANYNAME:
            	hours.get(hours.size()-1).getShop().getCompany().setName(elementValue);
            	break;
            case COMPANYPHONENUMBER:
            	hours.get(hours.size()-1).getShop().getCompany().setPhoneNumber(elementValue);
            	break;
            case COMPANYEMAIL:
            	hours.get(hours.size()-1).getShop().getCompany().setEmail(elementValue);
            	break;
        }
        
    }
 
    public ArrayList<BusinessHour> getBusinessHours() {
        return hours;
    }	

}
