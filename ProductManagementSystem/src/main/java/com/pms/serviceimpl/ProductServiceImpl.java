package com.pms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.Product;
import com.pms.exception.ProductNotFoundException;
import com.pms.repository.ProductRepository;
import com.pms.service.ProductService;

//implementing all method of ProductService
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository pr;

	//saving Product details using save() of jpaRepository
	@Override
	public Product saveProduct(Product product) {
		
		return pr.save(product);
	}

	//fetching all Product details using findAll() of JpaRepository
	@Override
	public List<Product> getAllProducts() {

		return pr.findAll();
	}

	//fetching Product details based on id using findById() of JpaRepository, if not found throw exception
	@Override
	public Product getProductById(int pid) {

		return pr.findById(pid).orElseThrow(() -> new ProductNotFoundException("No product exist in table"));
		
	}

	//fetching Product details based on id using findById() of JpaRepository, if not found throw exception
	//& update any contact details of Product
	@Override
	public Product updateProductById(Product product, int pid) {

		Product newproduct = pr.findById(pid).orElseThrow(() -> new ProductNotFoundException("No product exist in table"));
		newproduct.setPrice(product.getPrice());
		pr.save(newproduct);
		return newproduct;
		
	}

	//deleting Product details based on id using findById() of JpaRepository, if not found throw exception
	@Override
	public void deleteProductById(int pid) {

		pr.findById(pid).orElseThrow(() -> new ProductNotFoundException("No product exist in table"));
		pr.deleteById(pid);
		
	}

	//fetching all Product details using getPname() of JpaRepository
	@Override
	public List<Product> getPname(String pname) {
		
		return pr.getPname(pname);
	}

}
