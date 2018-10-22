package com.boot.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.boot.spring.model.Resource;

public interface ResourcesRepository extends CrudRepository<Resource, String>{
	
	List<Resource> findByTaskId(String taskId);
	
}
