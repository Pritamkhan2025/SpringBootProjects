package com.anudip.sms.service;

import java.util.List;


import com.anudip.sms.entity.Student;


//abstract method for performing CRUD on student entity
public interface StudentService {
	
		//saving details of student 
		Student saveStudent(Student student);
		
		//getting all details of student 
		List<Student> getAllStudent();
		
		//getting details of student based on uid
		Student getStudentById(int sid);
		
		//getting details of student based on uid & change mentioned details 
		Student updateStudentById(Student student, int sid);
		
		//getting details of student based on uid & delete mentioned student
		void deleteStudentById(int sid);

		//getting all details of student based on first name
		List<Student> getFname(String fname);

		//getting all details of student based on last name
		List<Student> getLname(String lname);
		
		//getting details of student based on phone number
		Student getPhone(long phone);

		//getting all details of student based on gender
		List<Student> getGender(String gender);

		//getting all details of student based on address
		List<Student> getAddress(String address);

		//getting all details of student based on stream
		List<Student> getStream(String stream);

	

}
