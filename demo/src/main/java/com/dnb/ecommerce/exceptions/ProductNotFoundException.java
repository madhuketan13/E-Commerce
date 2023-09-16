package com.dnb.ecommerce.exceptions;

public class ProductNotFoundException extends Exception{
	
	public ProductNotFoundException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return super.toString() + super.getMessage();
	}

}
