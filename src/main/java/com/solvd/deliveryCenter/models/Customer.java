package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.solvd.deliveryCenter.jaxb.adapters.DateAdapter;

@XmlRootElement(name = "customer")

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
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	
    @XmlElementWrapper
    @XmlElement
	public ArrayList<CustomerPhoneNumber> getPhones() {
		return phones;
	}
	
	@XmlElement
	public String getEmail() {
		return email;
	}
	
    @XmlElementWrapper
    @XmlElement
	public ArrayList<Address> getAddresses() {
		return addresses;
	}
	
	@XmlElement
	public String getLastName() {
		return lastName;
	}
	
	@XmlElement
	public String getFirstName() {
		return firstName;
	}
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	@XmlElement
	public java.sql.Date getBirthDate() {
		return birthDate;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setBirthDate(java.sql.Date birthDate) {
		this.birthDate = birthDate;
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
}
