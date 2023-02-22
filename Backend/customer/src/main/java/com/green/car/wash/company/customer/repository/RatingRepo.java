package com.green.car.wash.company.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.green.car.wash.company.customer.models.Ratings;
@Repository
public interface RatingRepo extends MongoRepository<Ratings,String>{

}
