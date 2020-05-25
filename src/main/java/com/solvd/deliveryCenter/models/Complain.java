package com.solvd.deliveryCenter.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.solvd.deliveryCenter.jaxb.adapters.DateAdapter;

@XmlRootElement(name = "complain")

public class Complain {
	private Long id;
	private Long orderId;
	private String description;
	private java.sql.Date date;
	private Order order;
	
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	
    @XmlElement
	public Long getOrderId() {
		return orderId;
	}
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	
	@XmlElement
	public String getDescription() {
		return description;
	}
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	@XmlElement
	public java.sql.Date getDate() {
		return date;
	}
	
	@XmlElement
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
}
