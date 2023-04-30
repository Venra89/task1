package com.example.task1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.task1.Repository.MongodbRepository;
import com.example.task1.model.Server;

@RestController
public class Controller {

	@Autowired
	private MongodbRepository repository;
	
	@PostMapping("/server")
	public String add(@RequestBody Server server) {
		repository.save(server);
		return "server added to collection";
	}
	
	@GetMapping("/server/{name}")
	public List<Server> getAll(@PathVariable String name) {
		
		List<Server>ans = new ArrayList<>();
		for(Server server : repository.findAll()) {
			if(server.getName().contains(name)) {
				ans.add(server);
			}
		}
		return ans;
	}
	
	@DeleteMapping("/server/{id}")
	public String delete(@PathVariable String id) {
		repository.deleteById(id);
		return "server deleted from collection";
	}
	
	@GetMapping("/server/all")
	public List<Server> getServer() {
		return repository.findAll();
	}
}
