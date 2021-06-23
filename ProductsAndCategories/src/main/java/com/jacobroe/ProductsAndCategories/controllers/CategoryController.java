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
public class CategoryController {
	
	// Add Category and Product Services
	private final CategoryService categoryService;
	private final ProductService productService;

	// Constructor
	public CategoryController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	// Create Cat
	@RequestMapping("/categories/new")
	public String newCategory(Model model, @ModelAttribute("category") Category category) {
		return "jsp/newCategory.jsp";
	}
	
	//Post Route for New Cat
	@PostMapping("/categories/new")
	public String addCat(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Product> products = productService.getAll();
			model.addAttribute("products", products);
			return "redirect:/categories/new";
		} else {
			categoryService.addCategory(category);
			return "redirect:/categories/" + category.getId();
		}
	}
	
	// Post Route for adding Products to Cat
	@PostMapping("/categories/{id}")
	public String updateCat(@PathVariable("id") Long categoryId, @RequestParam("product") Long productId) {
		Category category = categoryService.getOne(categoryId);
		Product product = productService.getOne(productId);
		List<Product> products = category.getProducts();
		products.add(product);
		categoryService.update(category);
		return "redirect:/categories/"+categoryId;
	}
	
	// Show Cat
	@RequestMapping("/categories/{id}")
	public String showCat(Model model, @PathVariable("id") Long id) {
		Category category = categoryService.getOne(id);
		model.addAttribute("category", category);
		model.addAttribute("products", productService.getAllExcept(id));
		return "jsp/showCategory.jsp";
	}
}