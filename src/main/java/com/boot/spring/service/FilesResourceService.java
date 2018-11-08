package com.boot.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boot.spring.model.FileResource;
import com.boot.spring.repository.FilesResourceRepository;

@Service
public class FilesResourceService {
	
	@Autowired
	private FilesResourceRepository repository;
	
	public List<FileResource> findByResourceId(String resourceId) {
		return repository.findByResourceId(resourceId);
	}
	
	public FileResource save(FileResource fileResource) {
		return repository.save(fileResource);
	}
	
}
