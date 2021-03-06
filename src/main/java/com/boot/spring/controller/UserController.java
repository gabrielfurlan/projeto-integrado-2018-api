package com.boot.spring.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.model.User;
import com.boot.spring.service.UsersService;
import com.boot.spring.utils.CryptUtil;
import com.boot.spring.utils.StatusUtil;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:8888"})
public class UserController {
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/{id:.+}")
	public @ResponseBody Response getOne(@PathVariable @NotNull String id) {		
		User user = usersService.findOne(id);
		
		if(user == null)
			return new Response(StatusUtil.NOT_FOUND, "User Not Found");
		
		return new Response(StatusUtil.SUCCESS, user);
	}
	
	@PostMapping("/{id}/verify")
	public @ResponseBody Response verifyPassword(@PathVariable @NotNull String id, @RequestBody User body) {		
		User user = usersService.findOne(id);
		
		if(user == null)
			return new Response(StatusUtil.NOT_FOUND, "User Not Found");
		
		if(!user.isValidPassword(body.getPassword()))
			return new Response(StatusUtil.WRONG_PASSWORD, "Wrong Password");
		
		return new Response(StatusUtil.SUCCESS, user);
	}
	
	@GetMapping("/generate-password/{password}")
	public String generatePassword(@PathVariable String password) {
		return CryptUtil.hash(password);
	}
	
	private class Response {
		public int status;
		public String message;
		public User user;
		
		public Response(int status) {
			this.status = status;
		}
		
		public Response(int status, User user) {
			this.status = status;
			this.user = user;
		}
		
		public Response(int status, String message) {
			this.status= status;
			this.message = message;
		}
		
		public Response(int status, User user, String message) {
			this.status = status;
			this.user = user;
			this.message = message;
		}
	}
	
}