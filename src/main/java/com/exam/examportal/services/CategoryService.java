package com.exam.examportal.services;

import java.util.Set;

import com.exam.examportal.entities.exam.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	
	public Category updateCategory(Category category);
	public Set<Category> getCategories();
	public Category getCategory(Long cid);
	
	public void deleteCategory(Long categoryId);
	

}
