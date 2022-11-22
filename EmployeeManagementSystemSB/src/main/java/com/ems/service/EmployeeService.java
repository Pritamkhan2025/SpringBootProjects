package com.ems.service;

import java.util.List;

import com.ems.entity.Employee;


//abstract method for performing CRUD on Employee entity
public interface EmployeeService {
	
	//saving details of employee
	Employee saveEmp(Employee emp);
	
	//getting all details of employee 
	List<Employee> getAllEmp();
	
	//getting details of employee based on eid
	Employee getEmpById(int eid);
	
	//getting details of employee based on eid & change mentioned details 
	Employee updateEmpById(Employee emp, int eid);
	
	//getting details of employee based on eid & delete mentioned employee
	void deleteEmpById(int eid);
	
	//getting all details of employee based on ename
	List<Employee> getEname(String ename);
	
	//getting all details of employee based on age
	List<Employee> getAge(int age);
	
	//getting details of employee based on phone number
	Employee getPhone(long ephone);

	//getting all details of employee based on skill
	List<Employee> getSkill(String skill);

	//getting all details of employee based on salary
	List<Employee> getSalary(Double salary);

	//getting all details of employee based on gender
	List<Employee> getGender(String gender);
	
	//getting all details of employee based on address
	List<Employee> getAddress(String address);
	

}
