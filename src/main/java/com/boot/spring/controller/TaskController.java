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

import com.boot.spring.model.Log;
import com.boot.spring.model.Task;
import com.boot.spring.model.User;
import com.boot.spring.service.LogsService;
import com.boot.spring.service.TasksService;
import com.boot.spring.utils.StatusUtil;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = { "http://localhost:8888" })
public class TaskController {
	
	@Autowired
	private TasksService tasks;
	
	@Autowired
	private LogsService logs;
	
	@GetMapping("/{id:.+}")
	public @ResponseBody Response getOne(@PathVariable @NotNull String id) {		
		Task task = tasks.findOne(id);
		
		if(task == null)
			return new Response(StatusUtil.NOT_FOUND, "Task Not Found");
		
		return new Response(StatusUtil.SUCCESS, task);
	}
	
	@PostMapping("/{id:.+}/edit-status")
	public @ResponseBody Response editStatus(@PathVariable @NotNull String id, @RequestBody Task body) {
		Task task = tasks.findOne(id);
		
		if(task == null)
			return new Response(StatusUtil.NOT_FOUND, "Task Not Found");
		
		task.setStatus(body.getStatus());
		task = tasks.save(task);
		
		return new Response(StatusUtil.SUCCESS, task);
	}
	
	@GetMapping("/{id:.+}/logs")
	public @ResponseBody List<Log> getLogs(@PathVariable @NotNull String id) {		
		return logs.findByTaskId(id);
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
