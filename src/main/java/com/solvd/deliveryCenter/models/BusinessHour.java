package com.solvd.deliveryCenter.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.solvd.deliveryCenter.jaxb.adapters.TimeAdapter;

@XmlRootElement(name = "businessHour")

public class BusinessHour {
	private Long id;
	private Long shopId;
	private String day;
	private java.sql.Time hour;
	private Shop shop;
	
	public BusinessHour() {
		// TODO Auto-generated constructor stub
	}
	
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setHour(java.sql.Time hour) {
		this.hour = hour;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	@XmlElement
	public Long getShopId() {
		return shopId;
	}
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	
	@XmlJavaTypeAdapter(TimeAdapter.class)
	@XmlElement
	public java.sql.Time getHour() {
		return hour;
	}
	
	@XmlElement
	public String getDay() {
		return day;
	}
	
	@XmlElement
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	@XmlElement
	public Shop getShop() {
		return shop;
	}
}
