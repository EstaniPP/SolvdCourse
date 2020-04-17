package com.solvd.carFactory.factories;

import com.solvd.carFactory.exceptions.PartNotFoundException;
import com.solvd.carFactory.exceptions.InvalidProductException;
import com.solvd.carFactory.factoryPersonal.EjecutiveEmployee;
import com.solvd.carFactory.factoryProducts.Order;
import com.solvd.carFactory.factoryProducts.Part;
import com.solvd.carFactory.factoryProducts.Product;

public class PartFactory extends Factory {
	
	private String specialization;
	
	public PartFactory(String name, EjecutiveEmployee director, String phone, String specialization) {
		super(name, director, phone);
		this.specialization = specialization;
	}
	
	public PartFactory() {
		this.specialization = "";
	}
	
	@Override
	public void produce(Order o) throws PartNotFoundException {
		Boolean exists = false;
		Part part = null;
		for(Product p : this.getProducts()) {
			if(p.getId() == o.getProduct()) {
				part = (Part) p;
				exists = true;
				break;
			}
		}
		if(exists == false) {throw new PartNotFoundException();}
		o.getClient().receive(part,o.getQuantity());
	}
	
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public String getSpecialization() {
		return specialization;
	}
	
	@Override
	public void addProduct(Product product) throws InvalidProductException {
		if(product instanceof Part) {
			super.getProducts().add(product);
		}else {
			throw new InvalidProductException();
		}
		
	}
}
