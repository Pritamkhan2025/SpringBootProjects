package com.pms.service;

import java.util.List;

import com.pms.entity.Product;

//abstract method for performing CRUD on Product entity
public interface ProductService {

	//saving details of Product entity
	Product saveProduct(Product product);
	
	//getting all details of product
	List<Product> getAllProducts();
	
	//getting details of product based on pid
	Product getProductById(int pid);
	
	//getting details of product based of pid & update mentioned details
	Product updateProductById(Product product, int pid);
	
	//getting details of product based of pid & delete mentioned details
	void deleteProductById(int pid);
	
	//getting all details of Product based on Product name
	List<Product> getPname(String pname);
	
}
