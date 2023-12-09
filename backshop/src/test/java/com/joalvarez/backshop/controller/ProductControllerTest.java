package com.joalvarez.backshop.controller;

import com.joalvarez.backshop.config.TestConfig;
import com.joalvarez.backshop.data.dto.ProductEntityDTO;
import com.joalvarez.backshop.service.ProductService; import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {ProductControllerTest.class, TestConfig.class})
public class ProductControllerTest {

	@Mock
	private ProductService service;
	@InjectMocks
	private ProductController controller;

	@Test
	public void testSave() {
		ProductEntityDTO dto = new ProductEntityDTO();

		when(this.service.save(dto)).thenReturn(dto);

		ResponseEntity<ProductEntityDTO> response = this.controller.save(dto);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(dto, response.getBody());

		verify(this.service, times(1)).save(dto);
	}

	@Test
	public void testGetAllPaginated() {
		int page = 0;
		int size = 10;

		Pageable pageable = PageRequest.of(page, size);

		Page<ProductEntityDTO> productEntityDTOS = new PageImpl<>(Collections.singletonList(new ProductEntityDTO()));

		when(this.service.getAllPaginated(pageable)).thenReturn(productEntityDTOS);

		ResponseEntity<Page<ProductEntityDTO>> response = this.controller.getAllPaginated(pageable);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(productEntityDTOS, response.getBody());

		verify(this.service, times(1)).getAllPaginated(pageable);
	}
}