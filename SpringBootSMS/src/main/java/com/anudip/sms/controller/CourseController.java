package com.anudip.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.sms.entity.Course;
import com.anudip.sms.service.CourseService;


@RestController
public class CourseController {
	
	@Autowired
	private CourseService cs;
	
	//save Course in db table using rest api PostMapping
	@PostMapping("/saveC")
	public ResponseEntity<Course> saveCourse(@Valid @RequestBody Course course){
		return new ResponseEntity<Course>(cs.saveCourse(course), HttpStatus.CREATED);
	}
	
	//fetch Course details from db table using rest api GetMapping
	@GetMapping("/getAllC")
	public List<Course> getAll(){
		return cs.getAllCourse();
	}
	
	//fetch Course details from db table using rest api GetMapping based on id
	@GetMapping("/getC/{cid}")
	public ResponseEntity<Course> getC(@PathVariable("cid") int cid){
		return new ResponseEntity<Course>(cs.getCourseById(cid),HttpStatus.OK);
	}
	
	//update Course details in db table using rest api PutMapping based on id
	@PutMapping("/updateC/{cid}")
	public ResponseEntity<Course> updateCourse(@PathVariable("cid") int cid, @RequestBody Course course){
			return new ResponseEntity<Course>(cs.updateCourseById(course, cid), HttpStatus.OK);
	}
		
	//delete Course details in db table using rest api PutMapping based on id
	@DeleteMapping("/deleteC/{cid}")
	public ResponseEntity<String> deleteCourse(@PathVariable("cid") int cid){
		cs.deleteCourseById(cid);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
	
	//fetch Course details from db table using rest api GetMapping based on courseNmae
	@GetMapping("/getCn/{courseName}")
	public List<Course> getcourseName(@PathVariable String courseName){
		return cs.getcourseName(courseName);
	}
	
	//fetch Course details from db table using rest api GetMapping based on fee
	@GetMapping("/getFee/{fee}")
	public List<Course> getFee(@PathVariable String fee){
		return cs.getFee(fee);
	}
	
}
