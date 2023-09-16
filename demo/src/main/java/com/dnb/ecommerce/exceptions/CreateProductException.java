package com.dnb.ecommerce.exceptions;

public class CreateProductException extends Exception{
	
	
	public CreateProductException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return super.toString() + super.getMessage();
	}

}
