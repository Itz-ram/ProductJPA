package com.db.util;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.product.entity.Product;

public class DataBaseUtil {
	public static void create(Product product) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ProductJPA");
		EntityManager entityManger = emFactory.createEntityManager( );
		entityManger.getTransaction().begin();
		
		entityManger.persist(product);
		
		entityManger.getTransaction().commit();
		entityManger.close();
		emFactory.close();
	}
	
	public static void update(Product product) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ProductJPA");
		EntityManager entityManager = emFactory.createEntityManager( );
		entityManager.getTransaction().begin();
		
		Product updateProduct = entityManager.find(Product.class, product.getId());
		updateProduct.setDescription(product.getDescription());
		updateProduct.setName(product.getName());
		updateProduct.setUnitPrice(product.getUnitPrice());
		updateProduct.setInStock(product.getInStock());
		
		entityManager.getTransaction().commit();
		entityManager.close();
		emFactory.close();	
	}

	public static void delete(Product product) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ProductJPA");
		EntityManager entityManger = emFactory.createEntityManager( );
		entityManger.getTransaction().begin();
		
		Product deleteProduct = entityManger.find(Product.class,product.getId());
		entityManger.remove(deleteProduct);
		
		entityManger.getTransaction().commit();
		entityManger.close();
		emFactory.close();
	}
	
	public static List<Product> read() {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ProductJPA");
		EntityManager entityManager = emFactory.createEntityManager( );
		
		List<Product> products = entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
		
		entityManager.close();
		emFactory.close();	
		return products;
	}
	
	
	
}
