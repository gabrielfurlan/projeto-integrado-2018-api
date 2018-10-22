package com.boot.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.spring.model.Resource;
import com.boot.spring.repository.ResourcesRepository;

@Service
public class ResourcesService {
	
	@Autowired
	private ResourcesRepository repository;
	
	public Resource save(Resource resource) {
		return repository.save(resource);
	}
	
	public List<Resource> findByTaskId(String taskId) {
		return repository.findByTaskId(taskId);
	}
	
}
