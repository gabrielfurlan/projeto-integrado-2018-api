package com.boot.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.boot.spring.model.Client;

@Repository
public interface ClientsRepository extends CrudRepository<Client, Long> {
	List<Client> findAll();
}
