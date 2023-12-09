package com.joalvarez.backshop.data.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ProductCategoryDTOTest {


	@Test
	public void testGetterAndSetter() {
		ProductCategoryDTO dto = new ProductCategoryDTO();
		UUID productId = UUID.randomUUID();
		int categoryId = 1;
		String description = "a description";

		CategoryDTO categoryDTO = new CategoryDTO();

		categoryDTO.setId(categoryId);
		categoryDTO.setDescription(description);

		dto.setProductId(productId);
		dto.setCategory(categoryDTO);

		assertAll(
			() -> assertEquals(productId, dto.getProductId()),
			() -> assertEquals(categoryId, dto.getCategory().getId()),
			() -> assertEquals(description, dto.getCategory().getDescription()),
			() -> Assertions.assertThat(dto)
				.extracting(ProductCategoryDTO::getProductId, ProductCategoryDTO::getCategory)
				.containsExactly(productId, categoryDTO)
		);

	}
}