package com.solvd.deliveryCenter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.deliveryCenter.jaxb.JAXBAddressParser;
import com.solvd.deliveryCenter.models.Address;
import com.solvd.deliveryCenter.models.Customer;


public class Runner {

	private final static Logger LOGGER = LogManager.getLogger(Runner.class);
	
	public static void main(String[] args) {
		
		Address a = new Address();
		a.setId(1l);
		a.setCity("Miramar");
		a.setCustomer(new Customer());
		a.setCustomerId(1l);
		a.setDirection("9 1344");
		a.setEstate("Buenos Aires");
		a.setPostalCode("7607");
		
		JAXBAddressParser ja = new JAXBAddressParser();
		
		ja.AddressToXML(a, "src/main/resources/address.xml");
		
		a = ja.XMLToAddress("src/main/resources/address.xml");
		
		LOGGER.info(a.getCity());
		LOGGER.info(a.getDirection());
		LOGGER.info(a.getEstate());
		LOGGER.info(a.getPostalCode());
		LOGGER.info(a.getCustomerId());
		LOGGER.info(a.getId());
	}

}
