package com.dnb.ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dnb.ecommerce.dto.Product;
import com.dnb.ecommerce.exceptions.ProductNameNotUniqueException;
import com.dnb.ecommerce.exceptions.ProductNotFoundException;

@Service
public interface ProductService {

	public Product createProduct(Product product);

	public Optional<Product> getProductById(String productId);

	public Iterable<Product> getAllProducts();

	public boolean deleteProduct(String productId);

	boolean existsById(String productId);

	Optional<Product> updateProduct(Product updatedProduct)
			throws ProductNameNotUniqueException, ProductNotFoundException;

}
