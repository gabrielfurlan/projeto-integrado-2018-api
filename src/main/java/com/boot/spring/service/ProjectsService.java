package com.boot.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.spring.model.Project;
import com.boot.spring.model.Task;
import com.boot.spring.repository.ProjectsRepository;
import com.boot.spring.repository.TasksRepository;

@Service
public class ProjectsService {

	@Autowired
	private ProjectsRepository projects;
	
	@Autowired
	private TasksRepository tasks;
	
	public Project save(Project project) {
		return projects.save(project);
	}
	
	public List<Project> find() {
		return projects.findAll(); 
	}
	
	public Project findOne(String id) {
		return projects.findOne(id);
	}
	
	public List<Task> findProjectTasks(String projectId) {
		return tasks.findByProjectId(projectId);
	}

}
