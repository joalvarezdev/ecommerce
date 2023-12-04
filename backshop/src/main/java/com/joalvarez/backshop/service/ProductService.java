package com.joalvarez.backshop.service;

import com.joalvarez.backshop.data.dao.ProductDAO;
import com.joalvarez.backshop.data.domain.Product;
import com.joalvarez.backshop.data.dto.ProductCategoryDTO;
import com.joalvarez.backshop.data.dto.ProductDTO;
import com.joalvarez.backshop.data.dto.ProductEntityDTO;
import com.joalvarez.backshop.data.mapper.ProductMapper;
import com.joalvarez.baseframework.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService extends BaseService<ProductDAO, ProductMapper, ProductDTO, Product, UUID> {

	private final ProductCategoryService productCategoryService;

	public ProductService(ProductDAO dao, ProductMapper mapper, ProductCategoryService productCategoryService) {
		super(dao, mapper);
		this.productCategoryService = productCategoryService;
	}

	public ProductEntityDTO save(ProductEntityDTO dto) {

		ProductDTO product = dto.getProduct();

		if (Objects.isNull(product.getId())) {
			product.setId(UUID.randomUUID());
		}

		this.dao.save(this.mapper.fromDTO(product));

		this.productCategoryService.save(dto.getCategories(), product.getId());

		return dto;
	}

	public Page<ProductEntityDTO> getAllPaginated(Pageable pageable) {
		Page<Product> products = this.dao.findAll(pageable);

		List<ProductEntityDTO> collect = products.get()
			.map(product -> {
				ProductEntityDTO productEntityDTO = new ProductEntityDTO();

				productEntityDTO.setProduct(this.mapper.toDTO(product));
				productEntityDTO.setCategories(this.productCategoryService.findByProductId(product.getId()));

				return productEntityDTO;
			})
			.collect(Collectors.toList());

		return new PageImpl<>(collect, products.getPageable(), products.getTotalElements());
	}
}
