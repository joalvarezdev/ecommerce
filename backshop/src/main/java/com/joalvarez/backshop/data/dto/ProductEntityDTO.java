package com.joalvarez.backshop.data.dto;

import com.joalvarez.backshop.data.types.Categories;
import com.joalvarez.baseframework.data.dto.BaseDTO;

import java.util.Set;

public class ProductEntityDTO implements BaseDTO {

	private ProductDTO product;
	private Set<Categories> categories;

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public Set<Categories> getCategories() {
		return categories;
	}

	public void setCategories(Set<Categories> categories) {
		this.categories = categories;
	}
}
