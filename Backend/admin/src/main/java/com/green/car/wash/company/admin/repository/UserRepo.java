package com.green.car.wash.company.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.green.car.wash.company.admin.model.Admin;
public interface UserRepo extends MongoRepository<Admin, String> {

	Admin findByUsername(String username);

	Boolean existsByUsername(String username);

}
