package com.boot.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.model.Resource;
import com.boot.spring.model.Task;
import com.boot.spring.service.ResourcesService;
import com.boot.spring.utils.StatusUtil;
import com.mysql.fabric.Response;


@RestController
@RequestMapping("/resources")
@CrossOrigin(origins = { "http://localhost:8888" })
public class ResourcesController {
	
	@Autowired
	private ResourcesService service;
	
	@PostMapping
	public @ResponseBody Response save(@RequestBody Resource body) {		
		body.setId(body.idGenerator());
		Resource resource = service.save(body);
		
		if(resource == null)
			return new Response(StatusUtil.NOT_FOUND, "Resource Not Found");
		
		return new Response(StatusUtil.SUCCESS, resource);
	}
	
	private class Response {
		public int status;
		public String message;
		public Resource resource;
		
		public Response(int status) {
			this.status = status;
		}
		
		public Response(int status, Resource resource) {
			this.status = status;
			this.resource = resource;
		}
		
		public Response(int status, String message) {
			this.status= status;
			this.message = message;
		}
		
		public Response(int status, Resource resource, String message) {
			this.status = status;
			this.resource = resource;
			this.message = message;
		}
	}
	
}
