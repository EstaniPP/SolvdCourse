package com.solvd.deliveryCenter.XMLParsers;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import com.solvd.deliveryCenter.models.Company;

public class XMLCompanyParser {

	SAXParserFactory factory;
	SAXParser saxParser;
	
	private final static Logger LOGGER = LogManager.getLogger(XMLCompanyParser.class);
	
	public XMLCompanyParser() {
			try {
				factory = SAXParserFactory.newInstance();
				saxParser = factory.newSAXParser();
			} catch (ParserConfigurationException | SAXException e) {
				LOGGER.error(e);
			}
	}
	
	
	public ArrayList<Company> parseCompanies(String filePath){	
		
		CompanyHandler handler = new CompanyHandler();
		try {
			saxParser.parse(filePath, handler);
		} catch (SAXException | IOException e) {
			LOGGER.error(e);
		}
		return handler.getCompanies();
	}
	
	
	
}