package com.boot.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.spring.model.Task;

@Repository
public interface TasksRepository extends CrudRepository<Task, String> {
	List<Task> findAll();
	List<Task> findByProjectId(String projectId);
}
