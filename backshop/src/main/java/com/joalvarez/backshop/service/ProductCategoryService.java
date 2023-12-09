package com.joalvarez.backshop.service;

import com.joalvarez.backshop.data.dao.ProductCategoryDAO;
import com.joalvarez.backshop.data.domain.Category;
import com.joalvarez.backshop.data.domain.Product;
import com.joalvarez.backshop.data.domain.ProductCategory;
import com.joalvarez.backshop.data.domain.ProductCategoryId;
import com.joalvarez.backshop.data.dto.CategoryDTO;
import com.joalvarez.backshop.data.dto.ProductCategoryDTO;
import com.joalvarez.backshop.data.mapper.ProductCategoryMapper;
import com.joalvarez.backshop.data.types.Categories;
import com.joalvarez.baseframework.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService extends BaseService<ProductCategoryDAO, ProductCategoryMapper, ProductCategoryDTO,
	ProductCategory, ProductCategoryId> {

	private final CategoryService categoryService;

	public ProductCategoryService(ProductCategoryDAO dao, ProductCategoryMapper mapper, CategoryService categoryService) {
		super(dao, mapper);
		this.categoryService = categoryService;
	}

	public void save(Set<Categories> categories, UUID idProduct) {
		categories.forEach(ent -> {
			CategoryDTO category = this.categoryService.findByDescription(ent.name());

			ProductCategory productCategory = new ProductCategory();

			ProductCategoryId id = new ProductCategoryId();

			id.setProductId(idProduct);
			id.setCategoryId(category.getId());

			productCategory.setId(id);

			this.dao.save(productCategory);
		});
	}

	public Set<Categories> findByProductId(UUID id) {
		return this.dao.findByProductId(id)
			.stream()
			.map(register -> {
				Categories[] values = Categories.values();
				Categories value = values[register.getId().getCategoryId()];

				return value;
			})
			.collect(Collectors.toSet());
	}
}
