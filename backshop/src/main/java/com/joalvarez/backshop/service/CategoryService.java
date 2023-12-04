package com.joalvarez.backshop.service;

import com.joalvarez.backshop.data.dao.CategoryDAO;
import com.joalvarez.backshop.data.domain.Category;
import com.joalvarez.backshop.data.dto.CategoryDTO;
import com.joalvarez.backshop.data.mapper.CategoryMapper;
import com.joalvarez.backshop.data.types.Categories;
import com.joalvarez.backshop.exception.GenericException;
import com.joalvarez.backshop.exception.InternalCode;
import com.joalvarez.baseframework.service.BaseService;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService extends BaseService<CategoryDAO, CategoryMapper, CategoryDTO, Category, Categories> {

	public CategoryService(CategoryDAO dao, CategoryMapper mapper) {
		super(dao, mapper);
	}

	public CategoryDTO findByDescription(String name) {
		return this.dao.findByDescription(name)
			.map(this.mapper::toDTO)
			.orElseThrow(() -> new GenericException(
				HttpStatus.BAD_REQUEST,
				InternalCode.ENTITY_NOT_FOUND,
				LogLevel.ERROR,
				"Un msg"
			));
	}
}
