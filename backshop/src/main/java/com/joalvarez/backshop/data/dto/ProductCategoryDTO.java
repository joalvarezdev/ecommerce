package com.joalvarez.backshop.data.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.joalvarez.baseframework.data.dto.BaseDTO;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductCategoryDTO implements BaseDTO {

	private UUID productId;
	private CategoryDTO category;

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
}
