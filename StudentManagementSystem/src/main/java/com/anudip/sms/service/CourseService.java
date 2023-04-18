package com.anudip.sms.service;

import java.util.List;

import com.anudip.sms.entity.Course;

//abstract method for performing CRUD on course entity
public interface CourseService {

	//saving details of course
	Course saveCourse(Course course);

	//getting all details of course
	List<Course> getAllCourse();

	//getting details of course based on cid
	Course getCourseById(int cid);

	//getting details of course based on cid & change mentioned details
	Course updateCourseById(Course course, int cid);

	//getting details of course based on cid & delete mentioned course
	void deleteCourseById(int cid);

	//getting details of course based on course name
	List<Course> getcourseName(String courseName);

	//getting details of course based on course fee
	List<Course> getFee(String fee);
	

}
