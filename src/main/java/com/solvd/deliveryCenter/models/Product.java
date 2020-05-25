package com.solvd.deliveryCenter.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")

public class Product {
	private Long id;
	private Long shopId;
	private String description;
	private Integer width;
	private Integer height;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public void setWidth(Integer width) {
		this.width = width;
	}
	
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setHeight(Integer height) {
		this.height = height;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
    @XmlElement
	public Integer getWidth() {
		return width;
	}
	
    @XmlElement
	public Long getShopId() {
		return shopId;
	}
	
    @XmlAttribute
	public Long getId() {
		return id;
	}
	
    @XmlElement
	public Integer getHeight() {
		return height;
	}
	
    @XmlElement
	public String getDescription() {
		return description;
	}
}
