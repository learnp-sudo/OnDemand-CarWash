package com.green.car.wash.company.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.green.car.wash.company.order.model.OrderDetails;

public interface OrderRepo extends MongoRepository<OrderDetails, String> {



}
