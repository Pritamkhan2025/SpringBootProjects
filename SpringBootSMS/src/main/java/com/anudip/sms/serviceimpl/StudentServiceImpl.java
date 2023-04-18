package com.anudip.sms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.anudip.sms.entity.Student;
import com.anudip.sms.exception.StudentNotFoundException;
import com.anudip.sms.repository.StudentRepository;
import com.anudip.sms.service.StudentService;

//implementing all method of StudentService
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository srepo;
	
	//saving student details using save() of jpaRepository
	@Override
	public Student saveStudent(Student student) {
		
		return srepo.save(student);
	}
	
	//fetching all student details using finalAll() of JpaRepository
	@Override
	public List<Student> getAllStudent() {
		
		return srepo.findAll();
		
	}

	//fetching student details based on id using findById() of JpaRepository, if not found throw exception
	@Override
	public Student getStudentById(int sid) {
		
		return srepo.findById(sid).orElseThrow(() -> new StudentNotFoundException("no student exists in table"));
		
	}

	//fetching student details based on id using findById() of JpaRepository, if not found throw exception
	//& update any contact details of student
	@Override
	public Student updateStudentById(Student student, int sid) {
		
		Student newstudent = srepo.findById(sid).orElseThrow(() -> new StudentNotFoundException("no student exists in table"));

		// updated value
		newstudent.setEmail(student.getEmail());
		newstudent.setPhone(student.getPhone());
		newstudent.setStream(student.getStream());
		newstudent.setAddress(student.getAddress());
		srepo.save(newstudent);
		return newstudent;
		
	}
	
	//deleting student details based on id using findById() of JpaRepository, if not found throw exception
	@Override
	public void deleteStudentById(int sid) {
		
		srepo.findById(sid).orElseThrow(() -> new StudentNotFoundException("no student exists in table"));
		srepo.deleteById(sid);
		
	}
	
	//fetching all student details using getFname() of JpaRepository
	@Override
	public List<Student> getFname(String fname) {

		return srepo.getFname(fname);
	}

	//fetching all student details using getLname() of JpaRepository
	@Override
	public List<Student> getLname(String lname) {
		
		return srepo.getLname(lname);
	}

	//fetching student details using getPhone() of JpaRepository
	@Override
	public Student getPhone(long phone) {
		
		return srepo.getPhone(phone);
	}

	//fetching all student details using getGender() of JpaRepository
	@Override
	public List<Student> getGender(String gender) {
		
		return srepo.getGender(gender);
	}

	//fetching all student details using getAddress() of JpaRepository
	@Override
	public List<Student> getAddress(String address) {
		
		return srepo.getAddress(address);
	}

	//fetching all student details using getStream() of JpaRepository
	@Override
	public List<Student> getStream(String stream) {
		
		return srepo.getStream(stream);
	}

}
