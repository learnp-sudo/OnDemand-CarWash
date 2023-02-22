package com.green.car.wash.company.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.green.car.wash.company.admin.model.WashPacks;
@Repository
public interface WashPackRepo extends MongoRepository<WashPacks, String> {
}
