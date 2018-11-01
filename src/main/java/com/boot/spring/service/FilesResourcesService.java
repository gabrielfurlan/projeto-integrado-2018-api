package com.boot.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.spring.model.FilesResource;
import com.boot.spring.repository.FilesResourcesRepository;

@Service
public class FilesResourcesService {
	
	@Autowired
	private FilesResourcesRepository repository;
	
	public FilesResource save(FilesResource resource) {
		return repository.save(resource);
	}
	
	public List<FilesResource> findByTaskId(String taskId) {
		return repository.findByTaskId(taskId);
	}
	
}