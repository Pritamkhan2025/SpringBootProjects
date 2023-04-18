package com.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pms.entity.Product;

//product repo extending JpaRepository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("select product from Product product where product.pname = ?1")
	List<Product> getPname(String pname);
	
}
