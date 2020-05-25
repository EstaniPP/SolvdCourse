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

import com.solvd.deliveryCenter.models.Address;

public class JAXBAddressParser {

	private final static Logger LOGGER = LogManager.getLogger(Address.class);
	
	public JAXBAddressParser() {
		// TODO Auto-generated constructor stub
	}
	
	public Address XMLToAddress(String filePath){ 
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Address.class );
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			InputStream file = new FileInputStream(filePath);
			return (Address) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			LOGGER.error(e);
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		}
		return null;		
	}
	
	public void AddressToXML(Address obj, String filePath) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Address.class);
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
