package com.product.entity;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.log.util.Logger;

public class Main {
	
	public static void printProducts() {
		JSONArray products = ProductUtil.get();
		if(products.size() == 0) {
			Logger.log("No products found");
		}
		for(Object product : products.toArray()) {
			Logger.log(product.toString());
		}
		Logger.log("\n");
	}

	public static void main(String[] args) {
		JSONObject productJSON = new JSONObject();
		productJSON.put("id", 2);
		productJSON.put("name", "Ipad");
		productJSON.put("description", "Smart tablet from apple");
		productJSON.put("unitPrice", 35999.99);
		productJSON.put("inStock", 1000);
		ProductUtil.create(productJSON);
		printProducts();
		
		
		//valid update case
		JSONObject productJSON1 = new JSONObject();
		productJSON1.put("id", 1);
		productJSON1.put("name","Apple Ipad");
		productJSON1.put("description","A new way of portable laptop");
		ProductUtil.update(productJSON1);
		printProducts();
		//valid delete case
		ProductUtil.delete(productJSON);
		
		printProducts();
		//invalid delete case
		ProductUtil.delete(productJSON1);
		
		
		

	}

}
