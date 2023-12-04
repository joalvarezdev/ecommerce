package com.joalvarez.backshop.data.repository;

import com.joalvarez.backshop.data.domain.Product;
import com.joalvarez.baseframework.data.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Transactional
public interface ProductRepository extends GenericRepository<Product, UUID> {
}
