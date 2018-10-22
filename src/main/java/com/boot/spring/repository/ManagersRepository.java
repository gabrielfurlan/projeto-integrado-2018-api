package com.boot.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.spring.model.Manager;

@Repository
public interface ManagersRepository extends CrudRepository<Manager, String> {
	List<Manager> findAll();
}
