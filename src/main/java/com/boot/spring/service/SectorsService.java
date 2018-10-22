package com.boot.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.spring.model.Sector;
import com.boot.spring.repository.SectorsRepository;
import com.boot.spring.utils.StatusUtil;

@Service
public class SectorsService {
	
	@Autowired
	private SectorsRepository sectorsRepository;

	public List<Sector> find() {
		return sectorsRepository.findAll(); 
	}
	
}
