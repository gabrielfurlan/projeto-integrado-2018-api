package com.boot.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.spring.model.Manager;
import com.boot.spring.repository.ManagersRepository;

@Service
public class ManagerService {
	
	@Autowired
	private ManagersRepository managers;
	
	public Manager save(Manager manager) {
		return managers.save(manager);
	}
	
	public List<Manager> find() {
		return managers.findAll(); 
	}
	
}
