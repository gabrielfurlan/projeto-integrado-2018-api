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

import com.boot.spring.model.Project;
import com.boot.spring.model.Task;
import com.boot.spring.service.ProjectsService;
import com.boot.spring.utils.StatusUtil;


@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = { "http://localhost:8888" })
public class ProjectsController {
	@Autowired
	private ProjectsService projects;
	
	@PostMapping
	public @ResponseBody Response save(@RequestBody Project body) {		
		body.setId(body.idGenerator());
		Project project = projects.save(body);
		
		if(project == null)
			return new Response(StatusUtil.NOT_FOUND, "Project Not Found");
		
		return new Response(StatusUtil.SUCCESS, project);
	}
	
	@GetMapping
	public @ResponseBody List<Project> get() {
		return  projects.find(); 
	}
	
	@GetMapping("/{projectId:.+}/tasks")
	public @ResponseBody List<Task> getProjectTasks(@PathVariable @NotNull String projectId) {
		return projects.findProjectTasks(projectId);
	}
	
	private class Response {
		public int status;
		public String message;
		public Project project;
		
		public Response(int status) {
			this.status = status;
		}
		
		public Response(int status, Project project) {
			this.status = status;
			this.project = project;
		}
		
		public Response(int status, String message) {
			this.status= status;
			this.message = message;
		}
		
		public Response(int status, Project client, String message) {
			this.status = status;
			this.project = project;
			this.message = message;
		}
	}
}

