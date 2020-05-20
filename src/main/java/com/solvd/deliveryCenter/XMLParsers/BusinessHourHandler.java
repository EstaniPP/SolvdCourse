package com.solvd.deliveryCenter.XMLParsers;

import java.sql.Time;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.solvd.deliveryCenter.models.BusinessHour;
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
	private static final String SHOPEMAIL = "shopemail";		
	   		 
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
            case SHOPID:
            	hours.get(hours.size()-1).setShopId(Long.valueOf(elementValue));
        }
        
    }
 
    public ArrayList<BusinessHour> getBusinessHours() {
        return hours;
    }	

}
