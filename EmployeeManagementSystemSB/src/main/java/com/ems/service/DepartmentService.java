package com.ems.service;

import java.util.List;


import com.ems.entity.Department;

//abstract method for performing CRUD on Department entity
public interface DepartmentService {

	//saving details of Department
	Department saveDept(Department dept);

	//getting all details of Department
	List<Department> getAllDept();

	//getting details of Department based on did
	Department getDeptById(int did);

	//getting details of Department based on did & change mentioned details
	Department updateDeptById(Department dept, int did);

	//getting details of Department based on did & delete mentioned Department
	void deleteDeptById(int did);

	//getting all details of Department based on department name
	List<Department> getDname(String dname);

	//getting details of Department based on phone number
	Department getDphone(long dphone);

	//getting all details of Department based on department city
	List<Department> getDcity(String dcity);

}
