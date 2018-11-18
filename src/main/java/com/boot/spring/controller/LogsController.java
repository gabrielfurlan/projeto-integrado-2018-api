package com.boot.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.model.Log;
import com.boot.spring.service.LogsService;
import com.boot.spring.utils.StatusUtil;

@RestController
@RequestMapping("/logs")
@CrossOrigin(origins = { "http://localhost:8888" })
public class LogsController {
	
	@Autowired
	private LogsService logs;
	
	@PostMapping
	public @ResponseBody Response save(@RequestBody Log body) {		
		body.setId(body.idGenerator());
		Log log = logs.save(body);
		
		if(log == null)
			return new Response<Log>(StatusUtil.NOT_FOUND, "Log Not Found");
		
		return new Response<Log>(StatusUtil.SUCCESS, log);
	}
	
	private class Response<Entity> {
		public int status;
		public String message;
		public Entity data;
		
		public Response(int status) {
			this.status = status;
		}
		
		public Response(int status, Entity data) {
			this.status = status;
			this.data = data;
		}
		
		public Response(int status, String message) {
			this.status= status;
			this.message = message;
		}
		
		public Response(int status, Entity data, String message) {
			this.status = status;
			this.data = data;
			this.message = message;
		}
	}
	
}
