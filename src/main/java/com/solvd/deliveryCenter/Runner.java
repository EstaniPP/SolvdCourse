package com.solvd.deliveryCenter;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IShopDAO;
import com.solvd.deliveryCenter.connectionPool.SQLSession;
import com.solvd.deliveryCenter.jaxb.JAXBCustomerParser;
import com.solvd.deliveryCenter.models.Address;
import com.solvd.deliveryCenter.models.Customer;
import com.solvd.deliveryCenter.models.Shop;

public class Runner {

	private final static Logger LOGGER = LogManager.getLogger(Runner.class);
	
	public static void main(String[] args) {
		
		//XML and JSON test
		Customer c = new Customer();
		c.setBirthDate(Date.valueOf("1997-04-04"));
		c.setEmail("estanipp@gmail.com");
		c.setFirstName("Estanislao");
		c.setLastName("Perez Peña");
		c.setId(1l);

		ArrayList<Address> addresses = new ArrayList<Address>();
		
		Address a = new Address();
		a.setId(1l);
		a.setCity("Miramar");
		a.setCustomer(new Customer());
		a.setCustomerId(1l);
		a.setDirection("9 1344");
		a.setEstate("Buenos Aires");
		a.setPostalCode("7607");
		addresses.add(a);
		
		a = new Address();
		a.setId(1l);
		a.setCity("Tandil");
		a.setCustomer(new Customer());
		a.setCustomerId(1l);
		a.setDirection("11 de septiembre 264");
		a.setEstate("Buenos Aires");
		a.setPostalCode("7000");
		addresses.add(a);
		
		c.setAddresses(addresses);
		
		LOGGER.info("Before using frameworks");
		LOGGER.info("Customer:");
		LOGGER.info(c.getId());
		LOGGER.info(c.getEmail());
		LOGGER.info(c.getFirstName());
		LOGGER.info(c.getLastName());
		LOGGER.info(c.getBirthDate());
		LOGGER.info("");
		for(Address address : c.getAddresses()) {
			LOGGER.info("Address:");
			LOGGER.info(address.getCity());
			LOGGER.info(address.getDirection());
			LOGGER.info(address.getEstate());
			LOGGER.info(address.getPostalCode());
			LOGGER.info(address.getId());
		}
		LOGGER.info("");
		LOGGER.info("");
		
		
		//XML section
		JAXBCustomerParser ja = new JAXBCustomerParser();
		
		ja.CustomerToXML(c, "src/main/resources/customer.xml");
		
		c = ja.XMLToCustomer("src/main/resources/customer.xml");
		
		LOGGER.info("After using JaxB");
		LOGGER.info("Customer:");
		LOGGER.info(c.getId());
		LOGGER.info(c.getEmail());
		LOGGER.info(c.getFirstName());
		LOGGER.info(c.getLastName());
		LOGGER.info(c.getBirthDate());
		LOGGER.info("");
		for(Address address : c.getAddresses()) {
			LOGGER.info("Address:");
			LOGGER.info(address.getCity());
			LOGGER.info(address.getDirection());
			LOGGER.info(address.getEstate());
			LOGGER.info(address.getPostalCode());
			LOGGER.info(address.getId());
		}
		LOGGER.info("");
		LOGGER.info("");
		
		
		//JSON section
		ObjectMapper mapper = new ObjectMapper();

		try {
			mapper.writeValue(new File("src/main/resources/customer.json"), c);
		} catch (JsonGenerationException e) {
			LOGGER.error(e);
		} catch (JsonMappingException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		}
		
		try {
			c = mapper.readValue(new File("src/main/resources/customer.json"), Customer.class);
		} catch (IOException e) {
			LOGGER.error(e);
		}

		LOGGER.info("After using Jackson");
		LOGGER.info("Customer:");
		LOGGER.info(c.getId());
		LOGGER.info(c.getEmail());
		LOGGER.info(c.getFirstName());
		LOGGER.info(c.getLastName());
		LOGGER.info(c.getBirthDate());
		LOGGER.info("");
		for(Address address : c.getAddresses()) {
			LOGGER.info("Address:");
			LOGGER.info(address.getCity());
			LOGGER.info(address.getDirection());
			LOGGER.info(address.getEstate());
			LOGGER.info(address.getPostalCode());
			LOGGER.info(address.getId());
		}
		
		//MyBatis test
		IShopDAO bhDao = SQLSession.getInstance().openSession(true).getMapper(IShopDAO.class);

		bhDao.getAllEntities().stream().forEach(b -> LOGGER.info(b.getId()));
		Shop b = bhDao.getAllEntities().stream().findAny().get();
		LOGGER.info(b.getId());
		LOGGER.info(b.getOpenHours().size());
		b.getOpenHours().stream().forEach(bh -> LOGGER.info(bh.getId()));
	}

}
