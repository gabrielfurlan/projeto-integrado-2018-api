package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import helpers.CryptHelper;
import models.User;

@RestController
public class AuthenticationController {
	
	@RequestMapping("/auth")
	public @ResponseBody User authentication() { 
		User user = new User();
		user.setFirstName("Gabriel");
		user.setId(user.idGenerator());
		user.setPassword(CryptHelper.hash("123"));
		return user;
	}
}
