package com.dnb.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.ecommerce.dto.Product;
import com.dnb.ecommerce.exceptions.CreateProductException;
import com.dnb.ecommerce.exceptions.IdNotFoundException;
import com.dnb.ecommerce.exceptions.ProductNameNotUniqueException;
import com.dnb.ecommerce.exceptions.ProductNotFoundException;
import com.dnb.ecommerce.payload.request.ProductRequest;
import com.dnb.ecommerce.service.ProductService;
import com.dnb.ecommerce.utils.RequestToEntityMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	RequestToEntityMapper mapper;

	@Autowired
	ProductService productService;

	@PostMapping("/create")
	public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequest product) throws CreateProductException {

		Product productRequest = mapper.getProductEntity(product);
		Product mappedProduct = productService.createProduct(productRequest);
		return new ResponseEntity(mappedProduct, HttpStatus.CREATED);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable("productId") String productId) throws IdNotFoundException {

		Optional<Product> optional = productService.getProductById(productId);
		if (optional.isPresent()) {

			return ResponseEntity.ok(optional.get());
		} else {

			throw new IdNotFoundException("ID not found");
		}

	}

	@PutMapping("/update/{productId}")

	public ResponseEntity<?> updateProduct(@RequestBody ProductRequest productRequest,
			@PathVariable("productId") String productId)
			throws InvalidNameException, IdNotFoundException, ProductNameNotUniqueException, ProductNotFoundException {

		Optional<Product> updatedProduct;

		if (productService.existsById(productId)) {

			Product product = mapper.getProductEntity(productRequest);
			product.setProductId(productId);
			updatedProduct = productService.updateProduct(product);

		}

		else

			throw new IdNotFoundException("Product Id Doesn't exist");

		return new ResponseEntity(updatedProduct, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable("productId") String productId) throws IdNotFoundException {
		if (productService.existsById(productId)) {
			productService.deleteProduct(productId);
			return ResponseEntity.ok("acc deleted");

		} else {
			throw new IdNotFoundException("Id not found");
		}

	}

	@GetMapping("/allProducts")
	public ResponseEntity<?> getAllProducts() {
		List<Product> result;

		result = (List<Product>) productService.getAllProducts();
		return ResponseEntity.ok(result);

	}

}
