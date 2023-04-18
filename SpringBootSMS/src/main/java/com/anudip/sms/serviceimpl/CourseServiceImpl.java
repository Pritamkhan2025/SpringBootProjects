package com.anudip.sms.serviceimpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.sms.entity.Course;
import com.anudip.sms.exception.CourseNotFoundException;
import com.anudip.sms.repository.CourseRepository;
import com.anudip.sms.service.CourseService;

//implementing all method of CourseService
@Service
public class CourseServiceImpl implements CourseService{
	
	
	@Autowired
	CourseRepository crepo;

	//saving course details using save() of jpaRepository
	@Override
	public Course saveCourse(@Valid Course course) {
		
		return crepo.save(course);
	}

	//fetching all course details using finalAll() of JpaRepository
	@Override
	public List<Course> getAllCourse() {
		
		return crepo.findAll();
	}

	//fetching course details based on id using findById() of JpaRepository, if not found throw exception
	@Override
	public Course getCourseById(int cid) {
		
		return crepo.findById(cid).orElseThrow(() -> new CourseNotFoundException("no course exists in table"));
	}
	
	//fetching course details based on id using findById() of JpaRepository, if not found throw exception
	//& update any contact details of course
	@Override
	public Course updateCourseById(Course course, int cid) {
		
		Course newcourse = crepo.findById(cid).orElseThrow(() -> new CourseNotFoundException("no Course exists in table"));

		// updated value
		newcourse.setFee(course.getFee());
		newcourse.setCourseDuration(course.getCourseDuration());
		crepo.save(newcourse);
		return newcourse;
		
	}

	//deleting course details based on id using findById() of JpaRepository, if not found throw exception
	@Override
	public void deleteCourseById(int cid) {
		
		crepo.findById(cid).orElseThrow(() -> new CourseNotFoundException("no course exists in table"));
		crepo.deleteById(cid);
		
	}

	//fetching all course details using getEname() of JpaRepository
	@Override
	public List<Course> getcourseName(String courseName) {
		
		return crepo.getCourseName(courseName);
	}

	//fetching all course details using getEname() of JpaRepository
	@Override
	public List<Course> getFee(String fee) {
		
		return crepo.getFee(fee);
	}

}
