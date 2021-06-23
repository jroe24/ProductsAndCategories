package com.jacobroe.ProductsAndCategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.jacobroe.ProductsAndCategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
}

