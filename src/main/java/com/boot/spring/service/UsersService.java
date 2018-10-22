package com.boot.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.spring.model.Analyst;
import com.boot.spring.model.Manager;
import com.boot.spring.model.User;
import com.boot.spring.repository.UsersRepository;
import com.boot.spring.repository.ManagersRepository;
import com.boot.spring.repository.AnalystsRepository;
import com.boot.spring.utils.StatusUtil;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private ManagersRepository managers;
	
	@Autowired
	private AnalystsRepository analysts;
	
	public List<User> find() {
		return  usersRepository.findAll(); 
	}
	
	public User save(User user) {
		user.setId(user.idGenerator());
		user = usersRepository.save(user);
		Manager manager = new Manager();
		Analyst analyst = new Analyst();
		
		System.out.println(user.getRole());
		
		if(user.getRole().equals("analyst")) {
			analyst.setId(analyst.idGenerator());
			analyst.setUserId(user.getId());
			analyst = analysts.save(analyst);
			user.setAnalystId(analyst.getId());
		}
		
		if(user.getRole() == "manager") {
			manager.setId(manager.idGenerator());
			manager.setUserId(user.getId());
			manager = managers.save(manager);
			user.setManagerId(manager.getId());
		}
		
		return usersRepository.save(user);
	}
	
	public User findOne(String id) {
		List<User> users = null;
		users = usersRepository.findOneByEmailOrId(id);
		
		if(users.isEmpty())
			return null;
		
		return users.get(0);
	}
	
}
