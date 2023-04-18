package com.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.entity.Product;
import com.pms.service.ProductService;

//product controller to handling all rest api incoming reques
@RestController
public class ProductController {
	
	@Autowired
	private ProductService pps;
	
	//save product in db table using rest api PostMapping
	@PostMapping("/saveProduct")
	public ResponseEntity<Product> saveProduct( @RequestBody Product product){
		return new ResponseEntity<Product>(pps.saveProduct(product) , HttpStatus.CREATED);
	}
	
	//fetch product details from db table using rest api GetMapping
	@GetMapping("/getAllproduct")
	public List<Product> getAllproduct(){
		return pps.getAllProducts();
	}
	
	//fetch product details from db table using rest api GetMapping based on pid
	@GetMapping("/getBypid/{pid}")
	public ResponseEntity<Product> getProductByPid(@PathVariable("pid") int pid){
		return new ResponseEntity<Product>(pps.getProductById(pid),HttpStatus.OK);
	}
	
	//update product details in db table using rest api PutMapping based on id
	@PutMapping("/updateProduct/{pid}")
	public ResponseEntity<Product> updateProduct(@PathVariable("pid") int pid, @RequestBody Product product){
		return new ResponseEntity<Product>(pps.updateProductById(product, pid), HttpStatus.OK);
	}
	
	//delete product details in db table using rest api PutMapping based on pid
	@DeleteMapping("/deleteProduct/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable("pid") int pid){
		pps.deleteProductById(pid);
		return new ResponseEntity<String>("product Deleted Successfully", HttpStatus.OK);
	}
	
	//get product details by product name
	@GetMapping("/getByProductName/{pname}")
	public List<Product> getProductByProductName(@PathVariable String pname){
		return pps.getPname(pname);
	}
	
}
