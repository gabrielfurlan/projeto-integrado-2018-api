package services;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import models.User;
import repositories.UsersRepository;

@Service
public class UsersService {
	
    @Autowired
    private UsersRepository usersRepository;

	public Iterable<User> findAll() {
		Iterable<User> users = usersRepository.findAll();
		return users;
	}
    
}
