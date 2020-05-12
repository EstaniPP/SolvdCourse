package com.solvd.carFactory.factoryProducts;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.carFactory.Runner;
import com.solvd.carFactory.exceptions.CarNoPartsException;

public abstract class Car extends Product {
	private String model;
	private String colour;
	private Integer autonomy;
	private Integer maxVelocity;
	private Integer peoplecapacity;
	private Integer year;
	private ArrayList<Part> carParts;
	private final static Logger LOGGER = LogManager.getLogger(Runner.class);
	
	public Car() {
		carParts = new ArrayList<Part>();
	}
	
	public Integer getAutonomy() {
		return autonomy;
	}
	
	public String getColour() {
		return colour;
	}
	
	public Integer getMaxVelocity() {
		return maxVelocity;
	}
	
	public String getModel() {
		return model;
	}
	
	public Integer getPeoplecapacity() {
		return peoplecapacity;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public void setAutonomy(Integer autonomy) {
		this.autonomy = autonomy;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public void setMaxVelocity(Integer maxVelocity) {
		this.maxVelocity = maxVelocity;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setPeoplecapacity(Integer peoplecapacity) {
		this.peoplecapacity = peoplecapacity;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public ArrayList<Part> getCarParts() throws CarNoPartsException {
		if(carParts == null || carParts.size() == 0) {
			throw new CarNoPartsException();
		}
		
		return carParts;
		
	}
	
	public void addCarPart(Part carPart) {
		carParts.add(carPart);
	}
	
	@Override
	public Double getPrice() {
		Double price = 0.0d;
		try {
			ArrayList<Part> parts = this.getCarParts();
			price = parts.stream().mapToDouble(p -> p.getPrice()).sum();
		}catch(CarNoPartsException e) {
			LOGGER.error(e);
		}
		return price*2;
	}

	public abstract void test();
	
	public abstract void turnOn();
	
	public abstract void turnOff();
}
