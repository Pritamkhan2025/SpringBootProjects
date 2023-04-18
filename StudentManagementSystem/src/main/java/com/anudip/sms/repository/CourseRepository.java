package com.anudip.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anudip.sms.entity.Course;

//course repo extending JpaRepository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	@Query("select c from Course c where c.courseName = ?1")
	List<Course> getCourseName(String courseName);

	@Query("select c from Course c where c.fee = ?1")
	List<Course> getFee(String fee);
	
}
