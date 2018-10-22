package com.boot.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.model.Sector;
import com.boot.spring.service.SectorsService;

@RestController
@RequestMapping("/sectors")
@CrossOrigin(origins = {"http://localhost:8888"})
public class SectorsController {
	
	@Autowired
	private SectorsService sectors;
	
	@GetMapping
	public @ResponseBody List<Sector> get() {
		return  sectors.find(); 
	}
	
}
