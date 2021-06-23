package com.jacobroe.ProductsAndCategories.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.jacobroe.ProductsAndCategories.models.Category;
import com.jacobroe.ProductsAndCategories.models.Product;
import com.jacobroe.ProductsAndCategories.repositories.CategoryRepository;
import com.jacobroe.ProductsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	// Add Product and Category Repos
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	
	// Constructor
	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	
	// New Product
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	// Update Product
	public void update(Product product) {
		productRepository.save(product);
	}
		
	// Get ALL Products
	public List<Product> getAll(){
		return (List<Product>) productRepository.findAll();
	}
	
	// Get Product by Id
	public Product getOne(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		else {
			return null;
		}
	}
	
	// Get all of the other Categories
	public List<Product> getAllExcept(Long categoryId) {
		List<Product> products = this.getAll();
		Optional<Category> category = categoryRepository.findById(categoryId);
		if (category.isPresent()) {
			List<Product> categoryProducts = category.get().getProducts();
			products.removeAll(categoryProducts);
			return products;
		} else {
			return null;
		}
	}
}