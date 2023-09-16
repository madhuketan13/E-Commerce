package com.dnb.ecommerce.utils;

import org.springframework.stereotype.Component;

import com.dnb.ecommerce.dto.Product;
import com.dnb.ecommerce.payload.request.ProductRequest;

@Component
public class RequestToEntityMapper {

	public Product getProductEntity(ProductRequest productRequest) {

		Product product = new Product();
		product.setName(productRequest.getName());
		product.setDescription(productRequest.getDescription());
		product.setPrice(productRequest.getPrice());
		product.setCategory(productRequest.getCategory());
		product.setExpiryDate(productRequest.getExpiryDate());

		return product;

	}
}
