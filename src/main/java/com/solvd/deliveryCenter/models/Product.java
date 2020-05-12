package com.solvd.deliveryCenter.models;

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
	
	public Integer getWidth() {
		return width;
	}
	
	public Long getShopId() {
		return shopId;
	}
	
	public Long getId() {
		return id;
	}
	
	public Integer getHeight() {
		return height;
	}
	
	public String getDescription() {
		return description;
	}
}
