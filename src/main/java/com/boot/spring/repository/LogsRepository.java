package com.boot.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.spring.model.Log;

@Repository
public interface LogsRepository extends CrudRepository<Log, String> {
	
	List<Log> findByTaskId(String taskId);
	
}
