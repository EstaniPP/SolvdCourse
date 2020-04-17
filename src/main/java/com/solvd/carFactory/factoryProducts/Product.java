package com.solvd.carFactory.factoryProducts;

public abstract class Product {
	private Integer id;
	private String name;
	private Double price;
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Product)) return false;
		Product p= (Product) obj;
		if(p.getId() == id) return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
}
