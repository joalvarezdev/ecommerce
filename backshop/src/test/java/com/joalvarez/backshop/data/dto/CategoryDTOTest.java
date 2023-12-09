package com.joalvarez.backshop.data.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryDTOTest {

	@Test
	public void testGetterAndSetter() {
		String description = "a description";
		int id = 1;
		CategoryDTO dto = new CategoryDTO();

		dto.setId(id);
		dto.setDescription(description);

		assertEquals(id, dto.getId());
		assertEquals(description, dto.getDescription());
		Assertions.assertThat(dto)
			.extracting(CategoryDTO::getId, CategoryDTO::getDescription)
			.containsExactly(id, description);
	}
}