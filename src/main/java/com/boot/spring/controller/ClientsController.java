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

import com.boot.spring.model.Client;
import com.boot.spring.service.ClientsService;
import com.boot.spring.utils.StatusUtil;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = { "http://localhost:8888" })
public class ClientsController {
	
	@Autowired
	private ClientsService clients;
	
	@PostMapping
	public @ResponseBody Response save(@RequestBody Client body) {		
		body.setId(body.idGenerator());
		Client client = clients.save(body);
		
		if(client == null)
			return new Response(StatusUtil.NOT_FOUND, "Client Not Found");
		
		return new Response(StatusUtil.SUCCESS, client);
	}
	
	@GetMapping
	public @ResponseBody List<Client> get() {
		return clients.find(); 
	}
	
	private class Response {
		public int status;
		public String message;
		public Client client;
		
		public Response(int status) {
			this.status = status;
		}
		
		public Response(int status, Client client) {
			this.status = status;
			this.client = client;
		}
		
		public Response(int status, String message) {
			this.status= status;
			this.message = message;
		}
		
		public Response(int status, Client client, String message) {
			this.status = status;
			this.client = client;
			this.message = message;
		}
	}
}
