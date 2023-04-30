package com.example.task1.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.task1.model.Server;

public interface MongodbRepository extends MongoRepository<Server, String> {

}
