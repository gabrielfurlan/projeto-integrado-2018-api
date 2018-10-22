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

import com.boot.spring.model.Task;
import com.boot.spring.service.TasksService;
import com.boot.spring.utils.StatusUtil;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = { "http://localhost:8888" })
public class TasksController {
	
	@Autowired
	private TasksService tasks;
	
	@PostMapping
	public @ResponseBody Response save(@RequestBody Task body) {		
		body.setId(body.idGenerator());
		System.out.println(body.getName());
		Task task = tasks.save(body);
		
		if(task == null)
			return new Response(StatusUtil.NOT_FOUND, "Task Not Found");
		
		return new Response(StatusUtil.SUCCESS, task);
	}
	
	@GetMapping
	public @ResponseBody List<Task> get() {
		return tasks.find(); 
	}
	
	private class Response {
		public int status;
		public String message;
		public Task task;
		
		public Response(int status) {
			this.status = status;
		}
		
		public Response(int status, Task task) {
			this.status = status;
			this.task = task;
		}
		
		public Response(int status, String message) {
			this.status= status;
			this.message = message;
		}
		
		public Response(int status, Task task, String message) {
			this.status = status;
			this.task = task;
			this.message = message;
		}
	}
}
