package com.exam.examportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examportal.entities.exam.Category;
import com.exam.examportal.services.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Category category){
		
		Category category1 = categoryService.addCategory(category);
		
		return ResponseEntity.ok(category1);
		
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<?> getCategory(@PathVariable Long categoryId){
		
		Category category1 = categoryService.getCategory(categoryId);
		
		return ResponseEntity.ok(category1);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllCategory(){
		
		
		return ResponseEntity.ok(categoryService.getCategories());
		
	}
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category){
		
		
		return categoryService.updateCategory(category);
		
	}
	@DeleteMapping("/{categoryId}")
	public void updateCategory(@PathVariable Long categoryId){
		
		 categoryService.deleteCategory(categoryId);;
		
	}

}
