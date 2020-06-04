package com.solvd.deliveryCenter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IBusinessHourDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IEntityDAO;
import com.solvd.deliveryCenter.jaxb.JAXBCustomerParser;
import com.solvd.deliveryCenter.models.Address;
import com.solvd.deliveryCenter.models.BusinessHour;
import com.solvd.deliveryCenter.models.Customer;
import com.solvd.deliveryCenter.models.Shop;
import com.sun.xml.bind.api.TypeReference;

public class Runner {

	private final static Logger LOGGER = LogManager.getLogger(Runner.class);
	
	public static void main(String[] args) {
	/*	Customer c = new Customer();
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
		
	 	*/
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			LOGGER.error(e);
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		IEntityDAO<Shop> bhDao = sqlSessionFactory.openSession(true).getMapper(IEntityDAO.class);
		
		/*BusinessHour bh = new BusinessHour();
		bh.setDay("Monday");
		bh.setHour(Time.valueOf("08:00:00"));
		bh.setShopId(2l);
		
		bhDao.saveEntity(bh);*/
		
		bhDao.getAllEntities().stream().forEach(b -> LOGGER.info(b.getId()));
		Shop b = bhDao.getAllEntities().stream().findAny().get();
		LOGGER.info(b.getId());
		LOGGER.info(b.getOpenHours().size());
		b.getOpenHours().stream().forEach(bh -> LOGGER.info(bh.getId()));/*
		
		IBusinessHourDAO bhDao2 = sqlSessionFactory.openSession(true).getMapper(IBusinessHourDAO.class);
		
		bhDao2.getAllEntities().stream().forEach(bh -> LOGGER.info(bh.getId()));*/
	}

}
