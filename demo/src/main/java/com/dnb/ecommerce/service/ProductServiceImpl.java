package com.dnb.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.ecommerce.dto.Product;
import com.dnb.ecommerce.exceptions.ProductNameNotUniqueException;
import com.dnb.ecommerce.exceptions.ProductNotFoundException;
import com.dnb.ecommerce.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	//Create a product
	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	//get a product by ID
	@Override
	public Optional<Product> getProductById(String productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId);
	}

	//get all products by ID
	@Override
	public Iterable<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public boolean deleteProduct(String productId) {

		if (productRepository.existsById(productId)) {
			productRepository.deleteById(productId);
			if (!productRepository.existsById(productId)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Optional<Product> updateProduct(Product updatedProduct)
			throws ProductNameNotUniqueException, ProductNotFoundException {
		String productName = updatedProduct.getName();

		Optional<Product> productWithSameName = productRepository.findByName(productName);

		if (productWithSameName.isPresent()) {
			Product existingProduct = productWithSameName.get();
			if (existingProduct.getName().equals(updatedProduct.getName())) {

				productRepository.save(updatedProduct);
				return Optional.of(updatedProduct);

			} else {
				throw new ProductNameNotUniqueException("Product name is not unique.");
			}
		} else {
			throw new ProductNotFoundException("Product not found with name: " + productName);
		}
	}

	@Override
	public boolean existsById(String productId) {
		return productRepository.existsById(productId);
	}

}
