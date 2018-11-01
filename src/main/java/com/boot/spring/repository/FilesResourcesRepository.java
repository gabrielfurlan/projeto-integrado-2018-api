package com.boot.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.boot.spring.model.FilesResource;

public interface FilesResourcesRepository extends CrudRepository<FilesResource, String>{
	
	List<FilesResource> findByTaskId(String resourceId);
	
}
