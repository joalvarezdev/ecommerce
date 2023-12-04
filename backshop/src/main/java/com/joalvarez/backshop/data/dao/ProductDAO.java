package com.joalvarez.backshop.data.dao;

import com.joalvarez.backshop.data.domain.Product;
import com.joalvarez.backshop.data.repository.ProductRepository;
import com.joalvarez.baseframework.data.dao.BaseJPADAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductDAO extends BaseJPADAO<ProductRepository, Product, UUID> {

	public ProductDAO(ProductRepository repository) {
		super(repository);
	}

	public Page<Product> findAll(Pageable pageable) {
		return this.getRepository().findAll(pageable);
	}
}
