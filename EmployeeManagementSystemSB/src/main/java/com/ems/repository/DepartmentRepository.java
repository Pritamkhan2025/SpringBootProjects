package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ems.entity.Department;


//department repo extending JpaRepository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
	@Query("select d from Department d where d.dname = ?1")
	List<Department> getDname(String dname);
	
	@Query("select d from Department d where d.dphone = ?1")
	Department getDphone(long dphone);

	@Query("select d from Department d where d.dcity = ?1")
	List<Department> getDcity(String dcity);
}
