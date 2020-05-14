package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

public class Customer {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private java.sql.Date birthDate;
	private ArrayList<Address> addresses;
	private ArrayList<CustomerPhoneNumber> phones;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public void setPhones(ArrayList<CustomerPhoneNumber> phones) {
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
	
	public ArrayList<CustomerPhoneNumber> getPhones() {
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
	
	public String getFirstName() {
		return firstName;
	}
	
	public java.sql.Date getBirthDate() {
		return birthDate;
	}
}
