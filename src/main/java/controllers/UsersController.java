package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import models.User;
import services.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@GetMapping("/users")
	public @ResponseBody List<User> users() {
		List<User> users = (List<User>) usersService.findAll(); 
		return users;
	}

}
