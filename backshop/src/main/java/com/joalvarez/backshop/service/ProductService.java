package com.joalvarez.backshop.service;

import com.joalvarez.backshop.data.dao.ProductDAO;
import com.joalvarez.backshop.data.domain.Product;
import com.joalvarez.backshop.data.dto.ProductDTO;
import com.joalvarez.backshop.data.dto.ProductEntDTO;
import com.joalvarez.backshop.data.mapper.ProductMapper;
import com.joalvarez.backshop.data.repository.ProductCategoryRepository;
import com.joalvarez.baseframework.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class ProductService extends BaseService<ProductDAO, ProductMapper, ProductDTO, Product, UUID> {

	private final ProductCategoryService productCategoryService;

	public ProductService(ProductDAO dao, ProductMapper mapper, ProductCategoryService productCategoryService) {
		super(dao, mapper);
		this.productCategoryService = productCategoryService;
	}

	public ProductEntDTO save(ProductEntDTO dto) {

		ProductDTO product = dto.getProduct();

		if (Objects.isNull(product.getId())) {
			product.setId(UUID.randomUUID());
		}

		this.dao.save(this.mapper.fromDTO(product));

		this.productCategoryService.save(dto.getCategories(), product.getId());

		return dto;
	}
}
