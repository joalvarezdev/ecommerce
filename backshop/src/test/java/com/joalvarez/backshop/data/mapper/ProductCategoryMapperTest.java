package com.joalvarez.backshop.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class ProductCategoryMapperTest {

	private ProductCategoryMapper mapper;
	@Mock
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setup() {
		this.mapper = new ProductCategoryMapper(this.objectMapper);
	}

	@Test
	public void constructor() {

	}
}