package com.joalvarez.backshop.data.repository;

import com.joalvarez.backshop.config.TestConfig;
import com.joalvarez.backshop.data.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(TestConfig.class)
public class CategoryRepositoryTest {

	private final static String CATEGORY_NAME = "PROBANDO 123";

	@Autowired
	private CategoryRepository repository;
	private Category category;

	@BeforeEach
	public void setupTestData() {

		this.category = new Category();

		category.setId(1);
		category.setDescription(CATEGORY_NAME);

	}

	@Test
	public void testFindByDescription() {
		// Given
		this.repository.save(category);

		// When
		Optional<Category> foundCategory = this.repository.findByDescription(CATEGORY_NAME);

		// Then
		assertTrue(foundCategory.isPresent());
		assertEquals(CATEGORY_NAME, foundCategory.get().getDescription());
	}
}