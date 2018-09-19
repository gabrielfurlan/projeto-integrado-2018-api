package com.boot.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.boot.spring.model.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> { 
	
	List<User> findAll();
	
	@Query("select u from User u where u.email = :string or u.id = :string")
	List<User> findOneByEmailOrId(@Param("string") String string);
}
 