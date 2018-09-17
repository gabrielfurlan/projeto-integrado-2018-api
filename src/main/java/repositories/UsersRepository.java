package repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import models.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
	
}

