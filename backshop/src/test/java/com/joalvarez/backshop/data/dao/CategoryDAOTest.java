package com.joalvarez.backshop.data.dao;

import com.joalvarez.backshop.config.TestConfig;
import com.joalvarez.backshop.data.domain.Category;
import com.joalvarez.backshop.data.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
@Import(TestConfig.class)
public class CategoryDAOTest {

	@InjectMocks
	private CategoryDAO dao;
	@Mock
	private CategoryRepository repository;

	@Test
	public void getCategoryByDescription() {
		String description = "Una descripción";
		Category entity = new Category();
		entity.setDescription(description);
		entity.setId(1);

		when(this.repository.findByDescription(description)).thenReturn(Optional.of(entity));

		Optional<Category> foundCategory = this.dao.findByDescription(description);

		assertAll(
			() -> assertTrue(foundCategory.isPresent()),
			() -> assertEquals(description, foundCategory.get().getDescription())
		);
	}
}