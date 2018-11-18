package com.boot.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.spring.model.Log;
import com.boot.spring.repository.LogsRepository;

@Service
public class LogsService {

	@Autowired
	private LogsRepository logs;
	
	public Log save(Log log) {
		return logs.save(log);
	}
	
	public List<Log> findByTaskId(String taskId) {
		return logs.findByTaskId(taskId);
	}
}
