package com.boot.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.spring.model.Client;
import com.boot.spring.repository.ClientsRepository;

@Service
public class ClientsService {
	
	@Autowired
	private ClientsRepository clientsRepository;
	
	public Client save(Client client) {
		return clientsRepository.save(client);
	}
	
	public List<Client> find() {
		return clientsRepository.findAll(); 
	}
}
