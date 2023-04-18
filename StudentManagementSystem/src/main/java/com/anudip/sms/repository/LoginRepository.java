package com.anudip.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.sms.entity.Login;


public interface LoginRepository extends JpaRepository<Login, Integer> {
	
	public Login findByUserNameAndPassword(String userName, String password);

}
