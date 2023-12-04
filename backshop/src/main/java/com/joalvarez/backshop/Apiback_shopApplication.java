package com.joalvarez.backshop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.joalvarez.backshop.data.dto.ProductDTO;
import com.joalvarez.backshop.data.dto.ProductEntityDTO;
import com.joalvarez.backshop.data.types.Categories;
import com.joalvarez.backshop.service.ProductService;
import com.joalvarez.baseframework.config.GlobalConfig;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@SpringBootApplication(scanBasePackages = GlobalConfig.BASE_PACKAGE)
public class Apiback_shopApplication {

	private ObjectMapper objectMapper;

	public static void main(String[] args) {
		SpringApplication.run(Apiback_shopApplication.class, args);
	}

/*
	@Bean
	CommandLineRunner init(ProductService service) {
		return args -> {
			for(int i = 0; i < 30; i++) {
				ProductEntityDTO dto = new ProductEntityDTO();
				Faker faker = new Faker();

				ProductDTO product = new ProductDTO();

				product.setId(UUID.randomUUID());
				product.setTitle(faker.commerce().productName());
				product.setDescription(faker.book().genre());
				product.setPrice(new BigDecimal(faker.commerce().price().replace(",", ".")));
				product.setThumbnail("URL IMagen");
				product.setStock(1);
				product.setDiscountPercentage(0D);
				product.setBrand("un BRAND");

				Set<Categories> categories = new HashSet<>();

				if (i % 2 == 0) {
					categories.add(Categories.DECO);
				} else {
					categories.add(Categories.BEBE);
					categories.add(Categories.NAVIDENO);
				}

				dto.setProduct(product);
				dto.setCategories(categories);

				service.save(dto);
			}
		};
	}
*/

	@Bean
	public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(this.objectMapper);
		this.objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
		return converter;
	}

	@Bean
	public RestTemplate restTemplate(@Autowired MappingJackson2HttpMessageConverter converter) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(List.of(converter));
		return restTemplate;
	}

	@Autowired
	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

}