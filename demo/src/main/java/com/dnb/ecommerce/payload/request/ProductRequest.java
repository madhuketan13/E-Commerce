package com.dnb.ecommerce.payload.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {
	
	
	@NotBlank(message = "name is required")
	private String name;
	
	@NotBlank(message = "Description must be provided")
	private String description;
	
	@NotNull(message = " Price should be mentioned")
	private int price;
	
	@NotBlank(message = "Please mention the category in which ")
	private String category;
	
	@NotNull(message = "Mention the expiry date")
	private LocalDate expiryDate;
}
