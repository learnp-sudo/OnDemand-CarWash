package com.green.car.wash.company.cart.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.green.car.wash.company.cart.model.Cart;


@Repository
public interface CartRepository extends MongoRepository<Cart,Integer> {
public Cart findById(int cartId);


}
