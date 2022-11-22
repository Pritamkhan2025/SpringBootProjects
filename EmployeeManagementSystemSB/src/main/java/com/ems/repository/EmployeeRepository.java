package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.ems.entity.Employee;


//employee repo extending JpaRepository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("select e from Employee e where e.ename = ?1")
	List<Employee> getEname(String ename);
	
	@Query("select e from Employee e where e.phone = ?1")
	Employee getPhone(long phone);

	@Query("select e from Employee e where e.skill = ?1")
	List<Employee> getSkill(String skill);
	
	@Query("select e from Employee e where e.salary = ?1")
	List<Employee> getSalary(double salary);
	
	@Query("select e from Employee e where e.gender = ?1")
	List<Employee> getGender(String gender);

	@Query("select e from Employee e where e.age = ?1")
	List<Employee> getAge(int age);

	@Query("select e from Employee e where e.address = ?1")
	List<Employee> getAddress(String address);
}
