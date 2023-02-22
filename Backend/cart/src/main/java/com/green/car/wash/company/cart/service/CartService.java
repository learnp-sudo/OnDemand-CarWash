package com.green.car.wash.company.cart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.green.car.wash.company.cart.model.Cart;

@Service
public interface CartService 
{
public Cart getCartById(int cartId);
public Cart updateCart(int cartId,Cart cart);
public List<Cart> getallcarts();
public double cartTotal(Cart cart);
public Cart addCart(Cart cart);
void deleteCartById(int cartId);

}
