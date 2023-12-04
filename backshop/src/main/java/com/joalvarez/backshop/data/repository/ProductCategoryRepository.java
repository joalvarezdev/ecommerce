package com.joalvarez.backshop.data.repository;

import com.joalvarez.backshop.data.domain.ProductCategory;
import com.joalvarez.backshop.data.domain.ProductCategoryId;
import com.joalvarez.baseframework.data.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ProductCategoryRepository extends GenericRepository<ProductCategory, ProductCategoryId> {

}
