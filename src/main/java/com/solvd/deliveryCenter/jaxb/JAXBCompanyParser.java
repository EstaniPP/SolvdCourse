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

import com.solvd.deliveryCenter.models.Company;

public class JAXBCompanyParser {

	private final static Logger LOGGER = LogManager.getLogger(JAXBCompanyParser.class);
	
	public JAXBCompanyParser() {
		// TODO Auto-generated constructor stub
	}
	
	public Company XMLToAddress(String filePath){ 
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Company.class );
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			InputStream file = new FileInputStream(filePath);
			return (Company) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			LOGGER.error(e);
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		}
		return null;		
	}
	
	public void CompanyToXML(Company obj, String filePath) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Company.class);
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