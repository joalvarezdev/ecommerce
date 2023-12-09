package com.joalvarez.backshop.service;

import com.joalvarez.backshop.config.TestConfig;
import com.joalvarez.backshop.data.dao.CategoryDAO;
import com.joalvarez.backshop.data.domain.Category;
import com.joalvarez.backshop.data.dto.CategoryDTO;
import com.joalvarez.backshop.data.mapper.CategoryMapper;
import com.joalvarez.backshop.exception.GenericException;
import com.joalvarez.backshop.exception.InternalCode;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {CategoryServiceTest.class, TestConfig.class})
public class CategoryServiceTest {

	@Mock
	private CategoryDAO dao;
	@Mock
	private CategoryMapper mapper;
	@InjectMocks
	private CategoryService service;

	@Test
	public void testFindByDescription() {
		String description = "Una descripción";
		Category category = new Category();
		category.setId(1);
		category.setDescription(description);

		CategoryDTO dto = new CategoryDTO();
		dto.setId(1);
		dto.setDescription(description);

		when(this.dao.findByDescription(description)).thenReturn(Optional.of(category));

		when(this.mapper.toDTO(category)).thenReturn(dto);

		CategoryDTO result = this.service.findByDescription(description);

		assertAll(
			() -> assertNotNull(result),
			() -> assertEquals(dto, result)
		);
	}

	@Test
	public void testThrowExceptionWhenEntityNotFound() {
		String description = "Una descripción";
		String message = "Un msg";

		when(this.dao.findByDescription(description)).thenReturn(Optional.empty());

		GenericException genericException = assertThrows(GenericException.class, () -> this.service.findByDescription(description));

		assertAll(
			() -> assertNotNull(genericException),
			() -> assertEquals(HttpStatus.BAD_REQUEST, genericException.getHttpStatus()),
			() -> assertEquals(InternalCode.ENTITY_NOT_FOUND, genericException.getInternalCode()),
			() -> assertEquals(LogLevel.ERROR, genericException.getLogLevel()),
			() -> assertEquals(message, genericException.getMessage())
		);
	}
}