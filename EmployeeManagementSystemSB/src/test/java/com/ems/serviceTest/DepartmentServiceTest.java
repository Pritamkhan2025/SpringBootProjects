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

import com.ems.entity.Department;
import com.ems.repository.DepartmentRepository;
import com.ems.service.DepartmentService;



@SpringBootTest
public class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService ds;
	
	@MockBean
	private DepartmentRepository drepo;
	
	//testing SaveDepartment of Department service
	@Test
	public void testSaveDepartment() {
		
		Department d = new Department();
		
		d.setDid(101);
		d.setDname("cse");
		d.setManager("sourav");
		d.setDphone(778955455);
		d.setDcity("kolkata");
		
		Mockito.when(drepo.save(d)).thenReturn(d);
		assertThat(ds.saveDept(d)).isEqualTo(d);
	}

	
	//testing saveAllDepartment of Department service
	@Test
	public void testSaveAllDepartment() {
		
		Department d = new Department();
		
		d.setDid(101);
		d.setDname("cse");
		d.setManager("sourav");
		d.setDphone(778955455);
		d.setDcity("kolkata");
		
		Department d1 = new Department();
		
		d1.setDid(202);
		d1.setDname("it");
		d1.setManager("karl");
		d1.setDphone(985955455);
		d1.setDcity("mumbai");
		
		List<Department> al = new ArrayList<>();
		al.add(d);
		al.add(d1);
		
		Mockito.when(drepo.save(d)).thenReturn(d);
		assertThat(ds.saveDept(d)).isEqualTo(d);
		
	}
	
	
	//testing updateDepartmrnt of department service
	@Test
	public void testUpdateDepartment() {
		
		Department d2 = new Department();
		
		d2.setDid(204);
		d2.setDname("finance");
		d2.setManager("jhon");
		d2.setDphone(9856755);
		d2.setDcity("pune");
		
		Optional<Department> da = Optional.of(d2);
		Department ua = da.get();
		
		Mockito.when(drepo.findById(204)).thenReturn(da);
		assertThat(ds.updateDeptById(ua, 204)).isEqualTo(ua);
		
	}
	

	
}
