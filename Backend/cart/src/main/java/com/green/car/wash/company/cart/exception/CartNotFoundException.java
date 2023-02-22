package com.green.car.wash.company.cart.exception;
public class CartNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CartNotFoundException(String message) {

		super(message);

	}

	public CartNotFoundException() {

	}

}
