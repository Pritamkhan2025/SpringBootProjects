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

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;

//user controller to handling all rest api incoming request
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService es;
	
	//save Employee in db table using rest api PostMapping
	@PostMapping("/saveE")
	public ResponseEntity<Employee> saveEmp(@Valid @RequestBody Employee emp){
		return new ResponseEntity<Employee>(es.saveEmp(emp), HttpStatus.CREATED);
	}
	
	// fetch Employee details from db table using rest api GetMapping
	@GetMapping("/getAllE")
	public List<Employee> getAll(){
		return es.getAllEmp();
	}
	
	//fetch Employee details from db table using rest api GetMapping based on id
	@GetMapping("/getE/{eid}")
	public ResponseEntity<Employee> getE(@PathVariable("eid") int eid){
		return new ResponseEntity<Employee>(es.getEmpById(eid),HttpStatus.OK);
	}
	
	//update Employee details in db table using rest api PutMapping based on id
	@PutMapping("/updateE/{eid}")
	public ResponseEntity<Employee> updateEmp(@PathVariable("eid") int eid, @RequestBody Employee emp){
			return new ResponseEntity<Employee>(es.updateEmpById(emp, eid), HttpStatus.OK);
	}
		
	//delete Employee details in db table using rest api PutMapping based on id
	@DeleteMapping("/deleteE/{eid}")
	public ResponseEntity<String> deleteEmp(@PathVariable("eid") int eid){
		es.deleteEmpById(eid);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
	
	//fetch Employee details from db table using rest api GetMapping based on name
	@GetMapping("/getEn/{ename}")
	public List<Employee> getEname(@PathVariable String ename){
		return es.getEname(ename);
	}
	
	//fetch Employee details from db table using rest api GetMapping based on phone number
	@GetMapping("/getPh/{phone}")
	public Employee getPhone(@PathVariable long phone){
		return es.getPhone(phone);
	}
	
	//fetch Employee details from db table using rest api GetMapping based on skill
	@GetMapping("/getSk/{skill}")
	public List<Employee> getSkill(@PathVariable String skill){
		return es.getSkill(skill);
	}
	
	//fetch Employee details from db table using rest api GetMapping based on salary
	@GetMapping("/getSal/{salary}")
	public List<Employee> getSalary(@PathVariable Double salary){
		return es.getSalary(salary);
	}
	
	//fetch Employee details from db table using rest api GetMapping based on gender
	@GetMapping("/getGen/{gender}")
	public List<Employee> getGender(@PathVariable String gender){
		return es.getGender(gender);
	}

	//fetch Employee details from db table using rest api GetMapping based on address
	@GetMapping("/getAdr/{address}")
	public List<Employee> getAddress(@PathVariable String address){
		return es.getGender(address);
	}
	
	//fetch Employee details from db table using rest api GetMapping based on age
	@GetMapping("/getAge/{age}")
	public List<Employee> getAge(@PathVariable int age){
		return es.getAge(age);
	}
	
}
