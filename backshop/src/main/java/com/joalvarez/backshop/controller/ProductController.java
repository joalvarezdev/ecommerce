package com.joalvarez.backshop.controller;

import com.joalvarez.backshop.data.dto.ProductDTO;
import com.joalvarez.backshop.data.dto.ProductEntDTO;
import com.joalvarez.backshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

	private final ProductService service;

	public ProductController (ProductService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<ProductEntDTO> save(@RequestBody ProductEntDTO product) {
		return ResponseEntity.ok(this.service.save(product));
	}
}
