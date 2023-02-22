package com.green.car.wash.company.washer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;


import com.green.car.wash.company.washer.model.WasherProfile;
@Repository
public interface WasherRepository extends MongoRepository<WasherProfile,String>{

	WasherProfile findByUsername(String username);

	boolean existsByUsername(String username);

}
