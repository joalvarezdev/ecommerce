package com.joalvarez.backshop.data.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class ProductCategoryId implements Serializable {

	private UUID productId;
	private int categoryId;

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProductCategoryId)) return false;
		ProductCategoryId that = (ProductCategoryId) o;
		return Objects.equals(getProductId(), that.getProductId()) &&
			getCategoryId() == that.getCategoryId();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getProductId(), getCategoryId());
	}
}
