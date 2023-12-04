package com.joalvarez.backshop.data.repository;

import com.joalvarez.backshop.data.domain.ProductCategory;
import com.joalvarez.backshop.data.domain.ProductCategoryId;
import com.joalvarez.baseframework.data.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface ProductCategoryRepository extends GenericRepository<ProductCategory, ProductCategoryId> {

    List<ProductCategory> findAllByIdProductId(UUID id);
}
