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

import com.anudip.sms.entity.Student;
import com.anudip.sms.service.StudentService;

//student controller to handling all rest api incoming request
@RestController
public class StudentController {
	
	@Autowired
	private StudentService ss;
	
	//save student in db table using rest api PostMapping
	@PostMapping("/saveS")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student){
		return new ResponseEntity<Student>(ss.saveStudent(student), HttpStatus.CREATED);
	}
	
	//fetch student details from db table using rest api GetMapping
	@GetMapping("/getAllS")
	public List<Student> getAll(){
		return ss.getAllStudent();
	}
	
	//fetch student details from db table using rest api GetMapping based on id
	@GetMapping("/getS/{sid}")
	public ResponseEntity<Student> getS(@PathVariable("sid") int sid){
		return new ResponseEntity<Student>(ss.getStudentById(sid),HttpStatus.OK);
	}
	
	//update student details in db table using rest api PutMapping based on id
	@PutMapping("/updateS/{sid}")
	public ResponseEntity<Student> updateStudent(@PathVariable("sid") int sid, @RequestBody Student student){
			return new ResponseEntity<Student>(ss.updateStudentById(student, sid), HttpStatus.OK);
	}
		
	//delete student details in db table using rest api PutMapping based on id
	@DeleteMapping("/deleteS/{sid}")
	public ResponseEntity<String> deleteStudent(@PathVariable("sid") int sid){
		ss.deleteStudentById(sid);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

	//fetch student details from db table using rest api GetMapping based on student first name
	@GetMapping("/getFn/{fname}")
	public List<Student> getFname(@PathVariable String fname){
		return ss.getFname(fname);
	}
	
	//fetch student details from db table using rest api GetMapping based on student last name
	@GetMapping("/getln/{lname}")
	public List<Student> getLname(@PathVariable String lname){
		return ss.getLname(lname);
	}
	
	//fetch student details from db table using rest api GetMapping based on student gender wise
	@GetMapping("/getGen/{gender}")
	public List<Student> getGender(@PathVariable String gender){
		return ss.getGender(gender);
	}
	
	//fetch student details from db table using rest api GetMapping based on student phone number
	@GetMapping("/getPh/{phone}")
	public Student getPhone(@PathVariable long phone){
		return ss.getPhone(phone);
	}
	
	//fetch student details from db table using rest api GetMapping based on student stream
	@GetMapping("/getStream/{stream}")
	public List<Student> getStream(@PathVariable String stream){
		return ss.getStream(stream);
	}

	//fetch student details from db table using rest api GetMapping based on student address
	@GetMapping("/getAddr/{address}")
	public List<Student> getAddress(@PathVariable String address){
		return ss.getAddress(address);
	}
}
