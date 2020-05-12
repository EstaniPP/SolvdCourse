package com.solvd.carFactory.factoryPersonal;

import java.util.HashMap;

import com.solvd.carFactory.factoryProducts.Product;

public class Client implements IReceive{

	private String name;
	private HashMap<Product,Integer> products; //product,quantity
	private String lastName;
	private String user;
	private String email;
	private String phoneNumber;
	
	public Client() {
		products = new HashMap<Product,Integer>();
	}
	
	public Client(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void receive(Product product, Integer quantity) {
		if(products.containsKey(product)) {
			products.put(product, products.get(product)+quantity);
		}else {
			products.put(product, quantity);
		}
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUser() {
		return user;
	}
	
	public HashMap<Product, Integer> getProducts() {
		return products;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}	
}
