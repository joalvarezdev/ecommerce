package com.joalvarez.backshop.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joalvarez.backshop.data.domain.Category;
import com.joalvarez.backshop.data.domain.Product;
import com.joalvarez.backshop.data.dto.ProductDTO;
import com.joalvarez.baseframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductMapper extends BaseMapper<ProductDTO, Product> {

	public ProductMapper(ObjectMapper mapper) {
		super(mapper);
	}

/*
	@Override
	public Product fromDTO(ProductDTO entity) {
		Product product = new Product();

		product.setId(entity.getId());
		product.setTitle(entity.getTitle());
		product.setDescription(entity.getDescription());
		product.setPrice(entity.getPrice());
		product.setDiscountPercentage(entity.getDiscountPercentage());
		product.setStock(entity.getStock());
		product.setThumbnail(entity.getThumbnail());
		product.setBrand(entity.getBrand());

		return product;
	}
*/

}
