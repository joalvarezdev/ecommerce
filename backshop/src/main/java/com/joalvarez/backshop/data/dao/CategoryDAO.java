package com.joalvarez.backshop.data.dao;

import com.joalvarez.backshop.data.domain.Category;
import com.joalvarez.backshop.data.repository.CategoryRepository;
import com.joalvarez.backshop.data.types.Categories;
import com.joalvarez.baseframework.data.dao.BaseJPADAO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoryDAO extends BaseJPADAO<CategoryRepository, Category, Categories> {

	public CategoryDAO(CategoryRepository repository) {
		super(repository);
	}

	public Optional<Category> findByDescription(String name) {
		return this.getRepository().findByDescription(name);
	}
}
