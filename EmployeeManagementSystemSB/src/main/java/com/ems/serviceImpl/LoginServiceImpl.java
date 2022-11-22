package com.ems.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ems.entity.Login;
import com.ems.repository.LoginRepository;
import com.ems.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginRepository lrepo;

	@Override
	public Login loginU(String userName, String password) {
		
		Login emp = lrepo.findByUserNameAndPassword(userName, password);
		return emp;
	}

}
