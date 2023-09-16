package com.dnb.ecommerce.dto;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.ecommerce.utils.CustomProductIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@GenericGenerator(name = "product_seq", strategy = "com.dnb.ecommerce.utils.CustomProductIdGenerator",
	parameters = {@Parameter(name = CustomProductIdGenerator.INCREMENT_PARAM, value = "1"),
	@Parameter(name = CustomProductIdGenerator.VALUE_PREFIX_PARAMETER, value = "PRO_"),
	@Parameter(name = CustomProductIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	private String productId;
	
	@NotBlank(message = "name is required")
	private String name;
	
	private String description;
	
	@NotNull(message = " Price should be mentioned")
	private int price;
	
	private String category;
	
	private LocalDate expiryDate;
	
}
