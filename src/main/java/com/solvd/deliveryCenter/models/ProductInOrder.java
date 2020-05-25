package com.solvd.deliveryCenter.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productInOrder")

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
	
    @XmlElement
	public Integer getQuantity() {
		return quantity;
	}
	
    @XmlElement
	public Long getProductId() {
		return productId;
	}
	
    @XmlElement
	public Long getOrderId() {
		return orderId;
	}
	
    @XmlAttribute
	public Long getId() {
		return id;
	}
}
