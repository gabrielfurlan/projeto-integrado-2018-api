package com.boot.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.spring.model.Analyst;

@Repository
public interface AnalystsRepository extends CrudRepository<Analyst, String> {
	
	List<Analyst> findAll();
	
}
