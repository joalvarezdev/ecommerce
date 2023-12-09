package com.joalvarez.backshop.data.repository;

import com.joalvarez.backshop.config.TestConfig;
import com.joalvarez.backshop.data.domain.ProductCategory;
import com.joalvarez.backshop.data.domain.ProductCategoryId;
import com.joalvarez.baseframework.utils.HasLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(TestConfig.class)
public class ProductCategoryRepositoryTest implements HasLogger {

	@Autowired
	private ProductCategoryRepository repository;
	private final UUID idTest = UUID.randomUUID();

	@BeforeEach
	public void setup() {
		for (int i = 0; i < 4; i++) {
			ProductCategoryId id = new ProductCategoryId();
			ProductCategory productCategory = new ProductCategory();

			id.setProductId(this.idTest);
			if (i == 3) {
				id.setProductId(UUID.randomUUID());
			}
			id.setCategoryId(i);

			productCategory.setId(id);

			this.repository.save(productCategory);
		}
	}

	@Test
	public void findAllProductsByProductId () {
		// Given
		//this.productCategories.forEach(this.repository::save);

		// When
		List<ProductCategory> allRegistriesByProductId = this.repository.findAllByIdProductId(this.idTest);

		// Then
		assertFalse(allRegistriesByProductId.isEmpty());
		assertEquals(3, allRegistriesByProductId.size());
	}

}