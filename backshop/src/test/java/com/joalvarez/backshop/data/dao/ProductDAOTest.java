package com.joalvarez.backshop.data.dao;

import com.joalvarez.backshop.config.TestConfig;
import com.joalvarez.backshop.data.domain.Product;
import com.joalvarez.backshop.data.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DataJpaTest
@Import(TestConfig.class)
public class ProductDAOTest {

	@InjectMocks
	private ProductDAO dao;
	@Mock
	private ProductRepository repository;

	@Test
	public void findAllPageable() {
		List<Product> productList = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			Product entity = new Product();

			entity.setId(UUID.randomUUID());
			entity.setTitle("Un titulo " + i);
			entity.setDescription("Una descripción");
			entity.setPrice(new BigDecimal("23.72"));
			entity.setDiscountPercentage(8.76D);
			entity.setStock(10);
			entity.setBrand("Un brand");
			entity.setThumbnail("Un thumbnail");

			productList.add(entity);
		}

		Pageable pageable = mock(Pageable.class);
		Page<Product> page = new PageImpl<>(productList);

		when(this.repository.findAll(pageable)).thenReturn(page);

		Page<Product> result = this.dao.findAll(pageable);

		verify(this.repository).findAll(pageable);

		assertAll(
			() -> assertFalse(result.isEmpty()),
			() -> assertEquals(productList.size(), result.getContent().size()),
			() -> assertEquals(productList.get(0).getTitle(), result.getContent().get(0).getTitle()),
			() -> assertEquals(productList.get(1).getTitle(), result.getContent().get(1).getTitle()),
			() -> assertEquals(productList.get(2).getTitle(), result.getContent().get(2).getTitle())
			);
	}
}