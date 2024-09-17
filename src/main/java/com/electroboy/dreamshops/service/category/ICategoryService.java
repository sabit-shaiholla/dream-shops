package com.electroboy.dreamshops.service.category;

import com.electroboy.dreamshops.model.Category;
import java.util.List;

public interface ICategoryService {
  Category getCategoryById(Long id);
  Category getCategoryByName(String name);
  List<Category> getAllCategories();
  Category addCategory(Category category);
  Category updateCategory(Long id, Category category);
  void deleteCategory(Long id);
}
