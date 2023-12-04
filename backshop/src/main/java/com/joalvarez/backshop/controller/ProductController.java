package com.joalvarez.backshop.controller;

import com.joalvarez.backshop.data.dto.ProductEntityDTO;
import com.joalvarez.backshop.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

	private final ProductService service;

	public ProductController (ProductService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<ProductEntityDTO> save(@RequestBody ProductEntityDTO product) {
		return ResponseEntity.ok(this.service.save(product));
	}

	@GetMapping
	public ResponseEntity<Page<ProductEntityDTO>> getAllPaginated(
		@ApiIgnore Pageable pageable,
		@RequestParam(required = false) Integer page,
		@RequestParam(required = false) Integer size
		) {
		return ResponseEntity.ok(this.service.getAllPaginated(pageable));
	}
}
