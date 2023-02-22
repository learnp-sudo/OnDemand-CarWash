package com.green.car.wash.company.customer.exceptionhandlers;

public class API_requestException extends RuntimeException{


	private static final long serialVersionUID = 1L;

	public API_requestException(String message, Throwable cause){
        super(message, cause);
    }

    public API_requestException(String message){
        super(message);
    }
}
