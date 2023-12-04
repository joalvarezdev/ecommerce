package com.joalvarez.backshop.data.repository;

import com.joalvarez.backshop.data.domain.Category;
import com.joalvarez.backshop.data.types.Categories;
import com.joalvarez.baseframework.data.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CategoryRepository extends GenericRepository<Category, Categories> {

	Optional<Category> findByDescription(String description);
}
