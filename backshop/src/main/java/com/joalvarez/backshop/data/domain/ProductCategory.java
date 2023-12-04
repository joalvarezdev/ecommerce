package com.joalvarez.backshop.data.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product_categories")
public class ProductCategory {

	@EmbeddedId
	private ProductCategoryId id;

	public ProductCategoryId getId() {
		return id;
	}

	public void setId(ProductCategoryId id) {
		this.id = id;
	}
}
