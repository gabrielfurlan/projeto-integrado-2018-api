package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import models.User;

@RestController
public class UsersController {
	
	@RequestMapping("/users")
	public String users() { 
		return "usuários";
	}

}
