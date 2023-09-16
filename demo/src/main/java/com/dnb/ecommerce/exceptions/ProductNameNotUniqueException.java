package com.dnb.ecommerce.exceptions;

public class ProductNameNotUniqueException extends Exception {
	
	public ProductNameNotUniqueException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return super.toString() + super.getMessage();
	}

}
