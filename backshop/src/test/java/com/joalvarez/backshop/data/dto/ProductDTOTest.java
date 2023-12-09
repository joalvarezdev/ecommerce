package com.joalvarez.backshop.data.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDTOTest {

	@Test
	public void testGetterAndSetters() {
		UUID id = UUID.randomUUID();
		String title = "Un titulo";
		String description = "Una descripción";
		BigDecimal price = new BigDecimal("23.2");
		Double discountPercentage = 12.3D;
		Integer stock = 10;
		String brand = "Un brand";
		String thumbnail = "Un thumbnail";

		ProductDTO dto = new ProductDTO();

		dto.setId(id);
		dto.setTitle(title);
		dto.setDescription(description);
		dto.setPrice(price);
		dto.setDiscountPercentage(discountPercentage);
		dto.setStock(stock);
		dto.setBrand(brand);
		dto.setThumbnail(thumbnail);

		assertAll(
			() -> assertEquals(id, dto.getId()),
			() -> assertEquals(title, dto.getTitle()),
			() -> assertEquals(description, dto.getDescription()),
			() -> assertEquals(price, dto.getPrice()),
			() -> assertEquals(discountPercentage, dto.getDiscountPercentage()),
			() -> assertEquals(stock, dto.getStock()),
			() -> assertEquals(brand, dto.getBrand()),
			() -> assertEquals(thumbnail, dto.getThumbnail()),
			() -> Assertions.assertThat(dto)
				.extracting(ProductDTO::getId, ProductDTO::getTitle, ProductDTO::getDescription, ProductDTO::getPrice,
					ProductDTO::getDiscountPercentage, ProductDTO::getStock, ProductDTO::getBrand, ProductDTO::getThumbnail)
				.containsExactly(id, title, description, price, discountPercentage, stock, brand, thumbnail)
		);

	}

}