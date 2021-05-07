package com.product.entity;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.db.util.DataBaseUtil;
import com.log.util.Logger;


public class ProductUtil {
	private static List<Product> products ;
	
	static {
		products = DataBaseUtil.read();
	}
	
	public static Product getProduct(int id) {
		if(products.stream().anyMatch(x -> x.getId() == id )) {
			return  products.stream().filter(x -> x.getId() == id).findAny().get();
		} else {
			return null;
		}
	}
	
	public static void create(JSONObject productJSON) {
		int id = (int) productJSON.get("id");
		if(getProduct(id) != null) {
			Logger.log("Product ID : " + id + " is already exists\n");
		} else {
			Product newProduct = new Product(
					(int) productJSON.get("id"),
					(String)productJSON.get("name"),
					(String)productJSON.get("description"),
					(double) productJSON.get("unitPrice"),
					(int) productJSON.get("inStock")
					);
			products.add(newProduct);
			DataBaseUtil.create(newProduct);
			Logger.log("Product ID : " + id + " has been successfullly created\n");
		}
	}
	
	public static void update(JSONObject productJSON) {
		int id = (int) productJSON.get("id");
		Product product = getProduct(id);
		if(product == null) {
			Logger.log("Product ID : " + id + " is not found \n");
		} else {
			String name = (String)productJSON.get("name");
			String description = (String)productJSON.get("description");
			Double unitPrice = (Double) productJSON.get("unitPrice");
			Integer inStock = (Integer) productJSON.get("inStock");
			if (name != null) {
				product.setName(name);
			}
			if (description != null) {
				product.setDescription(description);
			}
			if (unitPrice != null) {
				product.setUnitPrice(unitPrice);
			}
			if (inStock != null) {
				product.setInStock(inStock);
			}
			DataBaseUtil.update(product);
			Logger.log("Product Id : " + id + " has been updated \n" );
		}
		
		
	}
	
	public static void delete(JSONObject productJSON) {
		int id = (int) productJSON.get("id");
		Product product = getProduct(id);
		if(product == null) {
			Logger.log("Product ID : " + id + " is not found \n");
		} else {
			products.remove(product);
			DataBaseUtil.delete(product);
			Logger.log("Product Id : " + id + " has been deleted \n" );
		}
		
		
	}
	
	public static JSONArray get() {
		JSONArray allProducts = new JSONArray();
		products.forEach(x -> allProducts.add(x.getProductJSON()));
		return allProducts;
	}
}
