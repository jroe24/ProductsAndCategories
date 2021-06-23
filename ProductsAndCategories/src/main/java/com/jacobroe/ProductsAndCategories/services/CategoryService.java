package com.jacobroe.ProductsAndCategories.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.jacobroe.ProductsAndCategories.models.Category;
import com.jacobroe.ProductsAndCategories.models.Product;
import com.jacobroe.ProductsAndCategories.repositories.CategoryRepository;
import com.jacobroe.ProductsAndCategories.repositories.ProductRepository;


@Service
public class CategoryService {
	
	// Add Product and Category Repos
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	
	// Constructor
	public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
	
	// New Cat
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	// Update Cat
	public void update(Category category) {
		categoryRepository.save(category);
	}
	
	// Get ALL Categories
	public List<Category> getAll() {
		return (List<Category>) categoryRepository.findAll();
	}
	
	// Get Cat by the ID
	public Category getOne(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		if (category.isPresent()) {
			return category.get();
		}
		else {
			return null;
		}
	}
	
	// Get all of the other products
	public List<Category> getAllExcept(Long productId) {
		List<Category> categories = this.getAll();
		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent()) {
			List<Category> productCategories = product.get().getCategories();
			categories.removeAll(productCategories);
			return categories;
		} else {
			return null;
		}
	}
}