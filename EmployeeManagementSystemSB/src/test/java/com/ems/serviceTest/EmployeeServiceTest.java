package com.ems.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ems.entity.Employee;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;


//testing all CRUD of service
@SpringBootTest
public class EmployeeServiceTest {
	
	
	@Autowired
	private EmployeeService es;
	
	@MockBean
	private EmployeeRepository erepo;
	
	//testing SaveEmployee of employee service
	@Test
	public void testSaveEmployee() {
		
		Employee e = new Employee();
		e.setEid(1);
		e.setEname("pritam");
		e.setAge(24);
		e.setGender("male");
		e.setEmail("pritam@gmail.com");
		e.setPhone(981841194);
		e.setAddress("kolkata");
		e.setSkill("java");
		
		Mockito.when(erepo.save(e)).thenReturn(e);
		assertThat(es.saveEmp(e)).isEqualTo(e);
	}
	
	
	//testing saveAllEmployee of employee service
	@Test
	public void testSaveAllEmployee() {
		
		Employee e = new Employee();
		e.setEid(1);
		e.setEname("pritam");
		e.setAge(24);
		e.setGender("male");
		e.setEmail("pritam@gmail.com");
		e.setPhone(981841194);
		e.setAddress("kolkata");
		e.setSkill("java");
		
		Employee e1 = new Employee();
		e1.setEid(2);
		e1.setEname("suchi");
		e1.setAge(23);
		e1.setGender("female");
		e1.setEmail("suchi@gmail.com");
		e1.setPhone(818451194);
		e1.setAddress("kolkata");
		e1.setSkill("c");
		
		List<Employee> al = new ArrayList<>();
		al.add(e);
		al.add(e1);
		
		Mockito.when(erepo.save(e)).thenReturn(e);
		assertThat(es.saveEmp(e)).isEqualTo(e);
				
	}
	
	
	//testing updateEmployee of employee service
	@Test
	public void testUpdateEmployee() {
		
		Employee e2 = new Employee();
		
		e2.setEid(3);
		e2.setEname("sanjay");
		e2.setAge(25);
		e2.setGender("male");
		e2.setEmail("sanjay@gmail.com");
		e2.setPhone(685841194);
		e2.setAddress("delhi");
		e2.setSkill("python");
		
		Optional<Employee> ea = Optional.of(e2);
		Employee ua = ea.get();
		
		Mockito.when(erepo.findById(3)).thenReturn(ea);
		assertThat(es.updateEmpById(ua, 3)).isEqualTo(ua);
		
	}

}
