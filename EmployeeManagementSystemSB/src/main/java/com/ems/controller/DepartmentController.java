package com.ems.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.ems.entity.Department;
import com.ems.service.DepartmentService;

//department controller to handling all rest api incoming request
@RestController
public class DepartmentController {
	

	@Autowired
	private DepartmentService ds;
	
	//save Department in db table using rest api PostMapping
	@PostMapping("/saveD")
	public ResponseEntity<Department> saveDept(@Valid @RequestBody Department dept){
		return new ResponseEntity<Department>(ds.saveDept(dept), HttpStatus.CREATED);
	}
	
	// fetch Department details from db table using rest api GetMapping
	@GetMapping("/getAllD")
	public List<Department> getAll(){
		return ds.getAllDept();
	}
	
	//fetch Department details from db table using rest api GetMapping based on id
	@GetMapping("/getD/{did}")
	public ResponseEntity<Department> getD(@PathVariable("did") int did){
		return new ResponseEntity<Department>(ds.getDeptById(did),HttpStatus.OK);
	}
	
	//update Department details in db table using rest api PutMapping based on id
	@PutMapping("/updateD/{did}")
	public ResponseEntity<Department> updateDept(@PathVariable("did") int did, @RequestBody Department dept){
			return new ResponseEntity<Department>(ds.updateDeptById(dept, did), HttpStatus.OK);
	}
		
	//delete Department details in db table using rest api PutMapping based on id
	@DeleteMapping("/deleteD/{did}")
	public ResponseEntity<String> deleteDept(@PathVariable("did") int did){
		ds.deleteDeptById(did);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
	
	//fetch Department details from db table using rest api GetMapping based on name
	@GetMapping("/getDn/{dname}")
	public List<Department> getDname(@PathVariable String dname){
		return ds.getDname(dname);
	}
	
	//fetch Department details from db table using rest api GetMapping based phone number
	@GetMapping("/getDph/{dphone}")
	public Department getDphone(@PathVariable long dphone){
		return ds.getDphone(dphone);
	}
	
	//fetch Department details from db table using rest api GetMapping based on city
	@GetMapping("/getDcity/{dcity}")
	public List<Department> getDcity(@PathVariable String dcity){
		return ds.getDcity(dcity);
	}

}
