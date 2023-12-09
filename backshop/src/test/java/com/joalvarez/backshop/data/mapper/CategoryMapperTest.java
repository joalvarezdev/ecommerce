package com.joalvarez.backshop.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class CategoryMapperTest {

	private CategoryMapper mapper;
	@Mock
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setup() {
		this.mapper = new CategoryMapper(this.objectMapper);
	}

	@Test
	public void constructor() {
	}
}