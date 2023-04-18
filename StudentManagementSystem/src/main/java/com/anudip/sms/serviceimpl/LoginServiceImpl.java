package com.anudip.sms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.sms.entity.Login;
import com.anudip.sms.repository.LoginRepository;
import com.anudip.sms.service.LoginService;



@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginRepository lrepo;

	@Override
	public Login loginU(String userName, String password) {
		
		Login user = lrepo.findByUserNameAndPassword(userName, password);
		return user;
	}

}
