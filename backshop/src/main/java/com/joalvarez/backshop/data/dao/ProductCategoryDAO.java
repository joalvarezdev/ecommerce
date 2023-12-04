package com.joalvarez.backshop.data.dao;

import com.joalvarez.backshop.data.domain.ProductCategory;
import com.joalvarez.backshop.data.domain.ProductCategoryId;
import com.joalvarez.backshop.data.repository.ProductCategoryRepository;
import com.joalvarez.baseframework.data.dao.BaseJPADAO;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryDAO extends BaseJPADAO<ProductCategoryRepository, ProductCategory, ProductCategoryId> {

	public ProductCategoryDAO(ProductCategoryRepository repository) {
		super(repository);
	}
}
