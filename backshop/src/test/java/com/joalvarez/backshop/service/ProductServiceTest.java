package com.joalvarez.backshop.service;

import com.joalvarez.backshop.config.TestConfig;
import com.joalvarez.backshop.data.dao.ProductDAO;
import com.joalvarez.backshop.data.domain.Product;
import com.joalvarez.backshop.data.dto.ProductDTO;
import com.joalvarez.backshop.data.dto.ProductEntityDTO;
import com.joalvarez.backshop.data.mapper.ProductMapper;
import com.joalvarez.backshop.data.types.Categories;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {ProductServiceTest.class, TestConfig.class})
public class ProductServiceTest {

	@Mock
	private ProductCategoryService productCategoryService;
	@Mock
	private ProductMapper mapper;
	@Mock
	private ProductDAO dao;
	@InjectMocks
	private ProductService service;

	@Test
	public void testSaveEntity() {
		ProductEntityDTO dto = new ProductEntityDTO();
		ProductDTO productDTO = new ProductDTO();

		dto.setProduct(productDTO);
		dto.setCategories(Set.of(Categories.BEBE, Categories.DECORATION));

		ProductEntityDTO result = this.service.save(dto);

		verify(this.mapper, times(1)).fromDTO(any(ProductDTO.class));
		verify(this.productCategoryService, times(1)).save(any(), any(UUID.class));

		if (Objects.isNull(productDTO.getId())) {
			verify(UUID.randomUUID(), times(1));
		}

		assertAll(
			() -> assertNotNull(result.getProduct().getId())
		);
	}

	@Test
	public void testAllPaginated() {
		Pageable pageable = mock(Pageable.class);
		Page<Product> mockProducts = new PageImpl<>(Collections.singletonList(new Product()));

		when(this.dao.findAll(pageable)).thenReturn(mockProducts);
		when(this.mapper.toDTO(any())).thenReturn(new ProductDTO());
		when(this.productCategoryService.findByProductId(any())).thenReturn(Collections.emptySet());

		Page<ProductEntityDTO> result = this.service.getAllPaginated(pageable);

		verify(this.dao, times(1)).findAll(any(Pageable.class));
		verify(this.productCategoryService, times(mockProducts.getSize())).findByProductId(any());
		verify(this.mapper, times(mockProducts.getSize())).toDTO(any(Product.class));

		assertEquals(mockProducts.getSize(), result.getContent().size());
	}
}