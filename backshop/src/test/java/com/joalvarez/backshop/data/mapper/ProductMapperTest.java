package com.joalvarez.backshop.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

public class ProductMapperTest {

	private ProductMapper mapper;
	@Mock
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setup() {
		this.mapper = new ProductMapper(this.objectMapper);
	}

	@Test
	public void constructor() {}
}