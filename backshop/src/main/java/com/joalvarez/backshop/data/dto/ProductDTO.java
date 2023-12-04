package com.joalvarez.backshop.data.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.joalvarez.backshop.data.domain.ProductCategory;
import com.joalvarez.backshop.data.types.Categories;
import com.joalvarez.baseframework.data.dto.BaseDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDTO implements BaseDTO {

	private UUID id;
	private String title;
	private String description;
	private BigDecimal price;
	private Double discountPercentage;
	private Integer stock;
	private String brand;
	private String thumbnail;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
}
