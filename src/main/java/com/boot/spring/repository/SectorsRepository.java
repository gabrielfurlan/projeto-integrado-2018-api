package com.boot.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.boot.spring.model.Sector;

@Repository
public interface SectorsRepository extends CrudRepository<Sector, Long> {
	List<Sector> findAll();
}
