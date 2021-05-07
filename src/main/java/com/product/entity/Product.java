package com.product.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONObject;

@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private double unitPrice;
	private int inStock;
	
	public Product() {
	      super();
	}
	
	public Product(int id, String name, String description, double unitPrice, int inStock) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.inStock = inStock;
	}
	
	 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getInStock() {
		return inStock;
	}
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getProductJSON() {
		JSONObject	 productJSON = new JSONObject();
		productJSON.put("id", getId());
		productJSON.put("name", getName());
		productJSON.put("description", getDescription());
		productJSON.put("unitPrice", getUnitPrice());
		productJSON.put("inStock", getInStock());
		
		return productJSON;
		
	}


}
