package com.example.personalFinanceTracker.service;

import com.example.personalFinanceTracker.entity.Category;
import com.example.personalFinanceTracker.Repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepository;

    // Retrieve all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<Category> getAllCategoryTypes() {
        return categoryRepository.findAll();
    }

    // Retrieve a single category by its ID
    public Optional<Category> getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    // Add a new category
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Update an existing category by its ID
    public Category updateCategory(Long categoryId, Category categoryDetails) {
        return categoryRepository.findById(categoryId)
                .map(category -> {
                    category.setCategoryName(categoryDetails.getCategoryName());
                    category.setCategoryType(categoryDetails.getCategoryType());
                    return categoryRepository.save(category);
                })
                .orElse(null);  // If the category with the specified ID does not exist, return null
    }

    // Delete a category by its ID
    public boolean deleteCategory(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .map(category -> {
                    categoryRepository.delete(category);
                    return true;
                })
                .orElse(false);  // If the category with the specified ID does not exist, return false
    }
}
