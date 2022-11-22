package com.ems.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ems.entity.Employee;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;

//implementing all method of EmployeeService
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository erepo;

	
	//saving Employee details using save() of jpaRepository
	@Override
	public Employee saveEmp(Employee emp) {

		return erepo.save(emp);
	}

	
	//fetching all Employee details using finalAll() of JpaRepository
	@Override
	public List<Employee> getAllEmp() {

		return erepo.findAll();
	}
	

	//fetching Employee details based on id using findById() of JpaRepository, if not found throw exception
	@Override
	public Employee getEmpById(int eid) {

		return erepo.findById(eid).orElseThrow(() -> new EmployeeNotFoundException("no employee exists in table"));
	}

	
	//fetching employee details based on id using findById() of JpaRepository, if not found throw exception
	//& update any contact details of employee
	@Override
	public Employee updateEmpById(Employee emp, int eid) {
		
		Employee newemp = erepo.findById(eid).orElseThrow(() -> new EmployeeNotFoundException("no employee exists in table"));

		// updated value
		newemp.setEmail(emp.getEmail());
		newemp.setPhone(emp.getPhone());
		newemp.setSalary(emp.getSalary());
		newemp.setAddress(emp.getAddress());
		newemp.setSkill(emp.getSkill());
		newemp.setAge(emp.getAge());
		erepo.save(newemp);
		return newemp;
	}
	
	
	//deleting employee details based on id using findById() of JpaRepository, if not found throw exception
	@Override
	public void deleteEmpById(int eid) {
		
		erepo.findById(eid).orElseThrow(() -> new EmployeeNotFoundException("no employee exists in table"));
		erepo.deleteById(eid);
		
	}

	
	//fetching all Employee details using getEname() of JpaRepository
	@Override
	public List<Employee> getEname(String ename) {
		
		return erepo.getEname(ename);
	}


	//fetching Employee details using getPhone() of JpaRepository
	@Override
	public Employee getPhone(long phone) {
		
		return erepo.getPhone(phone);
	}

	
	//fetching all Employee details using getSkill() of JpaRepository
	@Override
	public List<Employee> getSkill(String skill) {

		return erepo.getSkill(skill);
	}


	//fetching all Employee details using getSalary() of JpaRepository
	@Override
	public List<Employee> getSalary(Double salary) {
		
		return erepo.getSalary(salary);
	}

	
	//fetching all Employee details using getGender() of JpaRepository
	@Override
	public List<Employee> getGender(String gender) {
		
		return erepo.getGender(gender);
	}


	//fetching all Employee details using getAge() of JpaRepository
	@Override
	public List<Employee> getAge(int age) {
		
		return erepo.getAge(age);
	}


	//fetching all Employee details using getAddress() of JpaRepository
	public List<Employee> getAddress(String address) {
		
		return erepo.getAddress(address);
	}


}
