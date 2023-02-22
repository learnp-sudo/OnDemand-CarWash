package com.green.car.wash.company.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.green.car.wash.company.customer.models.customerDetails;

public interface CustomerRepo extends MongoRepository<customerDetails, String> {

	customerDetails findByUsername(String username);

	boolean existsByUsername(String username);



}


