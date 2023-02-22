package com.green.car.wash.company.cart.service;

import java.util.List;
//import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.car.wash.company.cart.exception.CartAlreadyExistsException;
import com.green.car.wash.company.cart.exception.CartNotFoundException;
import com.green.car.wash.company.cart.model.Cart;
import com.green.car.wash.company.cart.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
	@Autowired
	CartRepository cartRepository;

	@Override
	public Cart getCartById(int cartId) throws CartNotFoundException {
		if (cartRepository.existsById(cartId)) {
			logger.info("Cart details of id exists " + cartId);
			return cartRepository.findById(cartId);
		} else {
			logger.warn("CART NOT FOUND WITH ID " + cartId);
			throw new CartNotFoundException("CART NOT FOUND WITH ID " + cartId);
		}
	}

	@Override
	public Cart updateCart(int cartId, Cart cart) throws CartNotFoundException {
		if (cartRepository.existsById(cartId)) {
			Cart updatedCart = cartRepository.findById(cartId);
			updatedCart.setCartId(cart.getCartId());
			updatedCart.setItems(cart.getItems());
			updatedCart.setTotalPrice(cart.getTotalPrice());
			cartRepository.save(updatedCart);
			return updatedCart;

		}
		else
		{
			logger.warn("NO CART FOUND WITH ID "+cartId);
			throw new CartNotFoundException("NO CART FOUND WITH ID "+cartId);
		}


	}

	@Override
	public List<Cart> getallcarts() throws CartNotFoundException {
		List<Cart> carts = cartRepository.findAll();
		if (carts.isEmpty()) {
			throw new CartNotFoundException("NO CARTS EXISTS");
		} else {
			return carts;
		}
	}

	@Override
	public double cartTotal(Cart cart) {

		return cart.getTotalPrice();
	}

	@Override
	public Cart addCart(Cart cart) throws CartAlreadyExistsException {

		return cartRepository.save(cart);

	}

	@Override
	public void deleteCartById(int cartId)
	{
	cartRepository.deleteById(cartId);

	}
}
