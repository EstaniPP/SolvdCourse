package com.solvd.carFactory.factories;

import com.solvd.carFactory.exceptions.PartNotFoundException;

import java.util.Optional;

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
		Optional<Product> exists = this.getProducts().stream().filter(p -> p.getId() == o.getProduct()).findFirst();
		if(!exists.isPresent()) {
			throw new PartNotFoundException();
		}else {
			o.getClient().receive(exists.get(),o.getQuantity());
		}
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
