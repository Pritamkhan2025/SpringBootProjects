package com.ems.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Department;
import com.ems.exception.DepartmentNotFoundException;
import com.ems.repository.DepartmentRepository;
import com.ems.service.DepartmentService;

//implementing all method of DepartmentService
@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	DepartmentRepository drepo;

	
	//saving Department details using save() of jpaRepository
	@Override
	public Department saveDept(Department dept) {
		
		return drepo.save(dept);
	}

	
	//fetching all Department details using finalAll() of JpaRepository
	@Override
	public List<Department> getAllDept() {

		return drepo.findAll();
	}

	
	//fetching Department details based on id using findById() of JpaRepository, if not found throw exception
	@Override
	public Department getDeptById(int did) {
		
		return drepo.findById(did).orElseThrow(() -> new DepartmentNotFoundException("no Department exists in table"));
	}

	
	//fetching Department details based on id using findById() of JpaRepository, if not found throw exception
	//& update any contact details of Department
	@Override
	public Department updateDeptById(Department dept, int did) {
		
		Department newdept = drepo.findById(did).orElseThrow(() -> new DepartmentNotFoundException("no Department exists in table"));

		// updated value
		newdept.setManager(dept.getManager());
		newdept.setDphone(dept.getDphone());
		newdept.setDcity(dept.getDcity());
		drepo.save(newdept);
		return newdept;
	}

	
	//deleting Department details based on id using findById() of JpaRepository, if not found throw exception
	@Override
	public void deleteDeptById(int did) {
		
		drepo.findById(did).orElseThrow(() -> new DepartmentNotFoundException("no Department exists in table"));
		drepo.deleteById(did);
		
	}

	
	//fetching all Department details using getDname() of JpaRepository
	@Override
	public List<Department> getDname(String dname) {
		
		return drepo.getDname(dname);
	}

	
	//fetching Department details using getDphone() of JpaRepository
	@Override
	public Department getDphone(long dphone) {
		
		return drepo.getDphone(dphone);
	}

	
	//fetching all Department details using getDcity() of JpaRepository
	@Override
	public List<Department> getDcity(String dcity) {
		
		return drepo.getDcity(dcity);
	}

}
