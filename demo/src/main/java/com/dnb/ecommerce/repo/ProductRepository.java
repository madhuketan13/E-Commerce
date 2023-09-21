package com.dnb.ecommerce.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.ecommerce.dto.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String>{
	
	//fetch product details from product name
	Optional<Product> findByName(String name);

}
