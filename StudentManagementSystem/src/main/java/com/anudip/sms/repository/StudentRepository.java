package com.anudip.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anudip.sms.entity.Student;


//student repo extending JpaRepository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	@Query("select s from Student s where s.fname = ?1")
	List<Student> getFname(String fname);

	@Query("select s from Student s where s.lname = ?1")
	List<Student> getLname(String lname);
	
	@Query("select s from Student s where s.phone = ?1")
	Student getPhone(long phone);
	
	@Query("select s from Student s where s.gender = ?1")
	List<Student> getGender(String gender);

	@Query("select s from Student s where s.stream = ?1")
	List<Student> getStream(String stream);

	@Query("select s from Student s where s.address = ?1")
	List<Student> getAddress(String address);


}
