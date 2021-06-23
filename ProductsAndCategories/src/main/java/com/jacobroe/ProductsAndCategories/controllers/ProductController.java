package com.jacobroe.ProductsAndCategories.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacobroe.ProductsAndCategories.models.Category;
import com.jacobroe.ProductsAndCategories.models.Product;
import com.jacobroe.ProductsAndCategories.services.CategoryService;
import com.jacobroe.ProductsAndCategories.services.ProductService;

@Controller
public class ProductController {
	
	// Add Category and Product Services
	private final CategoryService categoryService;
	private final ProductService productService;
	
	// Constructor
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	// Create Product
	@RequestMapping("/products/new")
	public String newProduct(Model model, @ModelAttribute("product") Product product) {
		return "jsp/newProduct.jsp";
	}
	
	//Post Route for New Product
	@PostMapping("/products/new")
	public String addProd(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Category> categories = categoryService.getAll();
			model.addAttribute("categories", categories);
			return "redirect:/products/new";
		} else {
			productService.addProduct(product);
			return "redirect:/products/" + product.getId();
		}
	}
	
	// // Post Route for adding Cat to Product
	@PostMapping("/{id}")
	public String updateProd(@PathVariable("id") Long productId, @RequestParam("category") Long categoryId) {
		Product product = productService.getOne(productId);
		Category category = categoryService.getOne(categoryId);
		List<Category> categories = product.getCategories();
		categories.add(category);
		productService.update(product);
		return "redirect:/products/"+productId;
	}
	
	// Show Product
	@RequestMapping("/products/{id}")
	public String showProd(Model model, @PathVariable("id") Long id) {
		Product product = productService.getOne(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.getAllExcept(id));
		return "jsp/showProduct.jsp";
	}
}