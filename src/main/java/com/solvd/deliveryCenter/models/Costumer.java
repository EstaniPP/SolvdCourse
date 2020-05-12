package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

public class Costumer {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private java.sql.Date birthDate;
	private ArrayList<Address> addresses;
	private ArrayList<CostumerPhoneNumber> phones;
	
	public Costumer() {
		// TODO Auto-generated constructor stub
	}
	
	public void setPhones(ArrayList<CostumerPhoneNumber> phones) {
		this.phones = phones;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddresses(ArrayList<Address> addresses) {
		this.addresses = addresses;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public ArrayList<CostumerPhoneNumber> getPhones() {
		return phones;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public ArrayList<Address> getAddresses() {
		return addresses;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setBirthDate(java.sql.Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getLastName() {
		return lastName;
	}
}
