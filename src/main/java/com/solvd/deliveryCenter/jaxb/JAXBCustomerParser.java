package com.solvd.deliveryCenter.jaxb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.deliveryCenter.models.Customer;

public class JAXBCustomerParser {

	private final static Logger LOGGER = LogManager.getLogger(JAXBCustomerParser.class);
	
	public JAXBCustomerParser() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer XMLToAddress(String filePath){ 
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Customer.class );
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			InputStream file = new FileInputStream(filePath);
			return (Customer) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			LOGGER.error(e);
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		}
		return null;		
	}
	
	public void CustomerToXML(Customer obj, String filePath) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			OutputStream os = new FileOutputStream(filePath);
			jaxbMarshaller.marshal(obj, os);
		} catch (JAXBException e) {
			LOGGER.error(e);
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		}
	}
}