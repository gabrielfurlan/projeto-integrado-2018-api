package com.boot.spring.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.model.User;
import com.boot.spring.repository.UsersRepository;
import com.boot.spring.utils.Status;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@GetMapping("/{id:.+}")
	public @ResponseBody Response getOne(@PathVariable @NotNull String id) {		
		List<User> user = null;
		user = usersRepository.findOneByEmailOrId(id);
		
		if(user.isEmpty())
			return new Response(Status.NOT_FOUND, "User Not Found");
		
		return new Response(Status.SUCCESS, user.get(0));
	}
	
	private class Response {
		public int code;
		public String message;
		public User user;
		
		public Response(int code) {
			this.code = code;
		}
		
		public Response(int code, User user) {
			this.code = code;
			this.user = user;
		}
		
		public Response(int code, String message) {
			this.code = code;
			this.message = message;
		}
		
		public Response(int code, User user, String message) {
			this.code = code;
			this.user = user;
			this.message = message;
		}
	}
	
}