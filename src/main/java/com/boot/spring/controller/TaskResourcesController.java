package com.boot.spring.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.model.Resource;
import com.boot.spring.service.ResourcesService;
import com.boot.spring.utils.StatusUtil;
import com.mysql.fabric.Response;


@RestController
@CrossOrigin(origins = { "http://localhost:8888" })
public class TaskResourcesController {
	
	@Autowired
	private ResourcesService service;
	
	@GetMapping("/task/{taskId:.+}/resources")
	public @ResponseBody List<Resource> find(@PathVariable @NotNull String taskId) {		
		return service.findByTaskId(taskId);
	}
}
