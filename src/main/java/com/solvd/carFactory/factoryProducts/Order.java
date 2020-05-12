package com.solvd.carFactory.factoryProducts;

import com.solvd.carFactory.factoryPersonal.IReceive;

public class Order {

	private Integer productId;
	private IReceive client;
	private Integer quantity;
	
	public Order(Integer productId, IReceive client, Integer quantity) {
		this.productId = productId;
		this.client = client;
		this.quantity = quantity;
	}
	
	public IReceive getClient() {
		return client;
	}
	
	public Integer getProduct() {
		return productId;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

}
