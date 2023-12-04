package com.joalvarez.backshop.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joalvarez.backshop.data.domain.Category;
import com.joalvarez.backshop.data.dto.CategoryDTO;
import com.joalvarez.baseframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper extends BaseMapper<CategoryDTO, Category> {

	public CategoryMapper(ObjectMapper mapper) {
		super(mapper);
	}


}
