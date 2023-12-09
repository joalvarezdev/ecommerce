package com.joalvarez.backshop.data.dao;

import com.joalvarez.backshop.config.TestConfig;
import com.joalvarez.backshop.data.domain.ProductCategory;
import com.joalvarez.backshop.data.domain.ProductCategoryId;
import com.joalvarez.backshop.data.repository.ProductCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
@Import(TestConfig.class)
public class ProductCategoryDAOTest {

	@InjectMocks
	private ProductCategoryDAO dao;
	@Mock
	private ProductCategoryRepository repository;
	private List<ProductCategory> productCategoryList;
	private final UUID idProduct = UUID.randomUUID();

	@BeforeEach
	public void setup() {
		this.productCategoryList = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			ProductCategory entity = new ProductCategory();
			ProductCategoryId id = new ProductCategoryId();

			id.setCategoryId(i);
			id.setProductId(idProduct);

			entity.setId(id);

			productCategoryList.add(entity);
		}
	}

	@Test
	public void findProductCategoriesByProductId() {

		when(this.repository.findAllByIdProductId(idProduct)).thenReturn(this.productCategoryList);

		List<ProductCategory> foundList = this.dao.findByProductId(this.idProduct);

		assertAll(
			() -> assertFalse(foundList.isEmpty()),
			() -> assertEquals(this.productCategoryList.size(), foundList.size())
		);
	}
}