package com.joalvarez.backshop.service;

import com.joalvarez.backshop.config.TestConfig;
import com.joalvarez.backshop.data.dao.ProductCategoryDAO;
import com.joalvarez.backshop.data.domain.ProductCategory;
import com.joalvarez.backshop.data.domain.ProductCategoryId;
import com.joalvarez.backshop.data.dto.CategoryDTO;
import com.joalvarez.backshop.data.mapper.ProductCategoryMapper;
import com.joalvarez.backshop.data.types.Categories;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {ProductCategoryServiceTest.class, TestConfig.class})
public class ProductCategoryServiceTest {

	@Mock
	private ProductCategoryDAO dao;
	@Mock
	private ProductCategoryMapper mapper;
	@Mock
	private CategoryService categoryService;
	@InjectMocks
	private ProductCategoryService service;

	@Test
	public void testSaveProductCategory() {
		UUID productId = UUID.randomUUID();
		Set<Categories> categories = new HashSet<>();
		Categories category1 = Categories.NAVIDENO;
		Categories category2 = Categories.DECORATION;

		categories.add(category1);
		categories.add(category2);

		CategoryDTO dto1 = new CategoryDTO();
		dto1.setDescription(category1.name());
		dto1.setId(category1.ordinal());

		CategoryDTO dto2 = new CategoryDTO();
		dto2.setDescription(category2.name());
		dto2.setId(category2.ordinal());

		when(this.categoryService.findByDescription(category1.name())).thenReturn(dto1);
		when(this.categoryService.findByDescription(category2.name())).thenReturn(dto2);

		this.service.save(categories, productId);

		verify(this.categoryService, times(categories.size())).findByDescription(anyString());
		verify(this.dao, times(categories.size())).save(any(ProductCategory.class));
	}

	@Test
	public void testFindByProductId() {
		UUID productId = UUID.randomUUID();

		List<ProductCategory> productCategories = new ArrayList<>();

		ProductCategory pc1 = new ProductCategory();
		ProductCategoryId id1 = new ProductCategoryId();

		id1.setProductId(productId);
		id1.setCategoryId(1);
		pc1.setId(id1);

		ProductCategory pc2 = new ProductCategory();
		ProductCategoryId id2 = new ProductCategoryId();

		id2.setCategoryId(2);
		id2.setProductId(productId);
		pc2.setId(id2);

		productCategories.add(pc1);
		productCategories.add(pc2);

		when(this.dao.findByProductId(productId)).thenReturn(productCategories);

		Set<Categories> byProductId = this.service.findByProductId(productId);

		assertAll(
			() -> assertEquals(productCategories.size(), byProductId.size())
		);
	}
}