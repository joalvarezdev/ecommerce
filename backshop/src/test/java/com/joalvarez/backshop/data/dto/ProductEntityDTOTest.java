package com.joalvarez.backshop.data.dto;

import com.joalvarez.backshop.data.types.Categories;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ProductEntityDTOTest {

	@Test
	public void testGetterAndSetter() {
		ProductEntityDTO dto = new ProductEntityDTO();
		ProductDTO productDTO = new ProductDTO();
		Set<Categories> categories = new HashSet<>();

		categories.add(Categories.BEBE);
		categories.add(Categories.DECORATION);
		categories.add(Categories.NAVIDENO);

		dto.setProduct(productDTO);
		dto.setCategories(categories);

		assertAll(
			() -> assertEquals(productDTO, dto.getProduct()),
			() -> assertEquals(categories, dto.getCategories()),
			() -> Assertions.assertThat(dto)
				.extracting(ProductEntityDTO::getProduct, ProductEntityDTO::getCategories)
				.containsExactly(productDTO, categories)
		);

	}
}