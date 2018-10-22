package com.boot.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.spring.model.Task;
import com.boot.spring.repository.TasksRepository;


@Service
public class TasksService {
	
	@Autowired
	private TasksRepository tasks;
	
	public Task save(Task task) {
		return tasks.save(task);
	}
	
	public List<Task> find() {
		return tasks.findAll(); 
	}
	
	public Task findOne(String id) {
		return tasks.findOne(id);
	}
	
}
