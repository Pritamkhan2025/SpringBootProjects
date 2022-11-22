package com.ems.controller;

import java.util.Date;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ems.entity.Login;
import com.ems.service.LoginService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
public class LoginController {
	
	
	@Autowired
	LoginService loginService;

	@PostMapping("/loginEmp")
	public String validate(@RequestBody Login user) throws ServletException {
		String jwtToken = "";

		if (user.getUserName() == null || user.getPassword() == null) {
			throw new ServletException("Please fill in username and password");
		}

		String userName = user.getUserName();
		String password = user.getPassword();
		user = loginService.loginU(userName, password);

		if (user == null) {
			throw new ServletException("Employee not found.");
		}

		jwtToken = Jwts.builder().setSubject(userName).claim("roles", "emp").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

		return jwtToken;
	}

}
