package com.boot.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/users")
@CrossOrigin(origins = {"http://localhost:8888", "http://192.168.1.128:8888"})
public class UsersController {
	
	@Autowired
	private UsersService users;
	
	@GetMapping
	public @ResponseBody List<User> get() {
		return  users.find(); 
	}
	
	@PostMapping
	public @ResponseBody Response save(@RequestBody User body) {		
		User user = null;
		user = users.findOne(body.getEmail());
		
		if(user != null)
			return new Response(StatusUtil.DUPLICATE_EMAIL, "Duplicate Email");
		
		body.setId(body.idGenerator());
		body.setPassword(CryptUtil.hash("123123"));
		
		user = users.save(body);
		
		if(user == null)
			return new Response(StatusUtil.INTERNAL_SERVER_ERROR, "Internal Server Error");
		
		return new Response(StatusUtil.SUCCESS, user);
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
