package com.joalvarez.backshop.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joalvarez.backshop.data.domain.ProductCategory;
import com.joalvarez.backshop.data.dto.ProductCategoryDTO;
import com.joalvarez.baseframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryMapper extends BaseMapper<ProductCategoryDTO, ProductCategory> {

	public ProductCategoryMapper(ObjectMapper mapper) {
		super(mapper);
	}

}
