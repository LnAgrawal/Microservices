package com.training.dto;

import com.training.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ProductEvent {

    private String eventType;
    private Product product;
    
	public ProductEvent() {
	}

	public ProductEvent(String eventType, Product product) {
		this.eventType = eventType;
		this.product = product;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductEvent [eventType=" + eventType + ", product=" + product + "]";
	}
    
}
