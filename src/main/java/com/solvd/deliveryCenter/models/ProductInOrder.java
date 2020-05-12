package com.solvd.deliveryCenter.models;

public class ProductInOrder {
	private Long id;
	private Long orderId;
	private Long productId;
	private Integer quantity;
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public Long getProductId() {
		return productId;
	}
	
	public Long getOrderId() {
		return orderId;
	}
	
	public Long getId() {
		return id;
	}
}
