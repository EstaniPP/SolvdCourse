package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.solvd.deliveryCenter.jaxb.adapters.DateAdapter;

@XmlRootElement(name = "order")

public class Order {
	private Long id;
	private Long vehicleId;
	private Long addressId;
	private Long employeeId;
	private Integer price;
	private java.sql.Date date;
	private ArrayList<ProductInOrder> products;
	private Complain complain;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	public void setProducts(ArrayList<ProductInOrder> products) {
		this.products = products;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
    @XmlElement
	public Long getVehicleId() {
		return vehicleId;
	}
	
    @XmlElementWrapper
    @XmlElement
	public ArrayList<ProductInOrder> getProducts() {
		return products;
	}
	
    @XmlElement
	public Integer getPrice() {
		return price;
	}
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	
    @XmlElement
	public Long getEmployeeId() {
		return employeeId;
	}
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	@XmlElement
	public java.sql.Date getDate() {
		return date;
	}
	
    @XmlElement
	public Long getAddressId() {
		return addressId;
	}	
	
    @XmlElement
	public Complain getComplain() {
		return complain;
	}
	
	public void setComplain(Complain complain) {
		this.complain = complain;
	}
}
