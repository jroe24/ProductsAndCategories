package com.jacobroe.ProductsAndCategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.jacobroe.ProductsAndCategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository <Category, Long> {
}