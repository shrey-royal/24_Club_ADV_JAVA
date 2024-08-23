package com.bean;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Product, Integer> items = new HashMap<Product, Integer>();
	
	public void addProduct(Product product) {
		items.put(product, items.getOrDefault(product, 0) + 1);
	}
	
	public Map<Product, Integer> getItems() {
		return items;
	}
	
	public double getTotalPrice() {
		return items.entrySet().stream()
				.mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
				.sum();
	}
}
