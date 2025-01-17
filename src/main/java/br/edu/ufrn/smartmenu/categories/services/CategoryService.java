package br.edu.ufrn.smartmenu.categories.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufrn.smartmenu.categories.models.Category;
import br.edu.ufrn.smartmenu.categories.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> getAllCategories() {
        List<Category> allCategories = this.repository.findAll();

        return allCategories;
    }

    public Category getCategoryById(
        Long id
    ) throws NoSuchElementException {
        Category category = this.repository.findById(id).get();
        
        return category;
    }

    public Category createCategory(
        Category category
    ) {

        category = this.repository.save(category);
        
        return category;
    }

    public Category updateCategory(
        Long id,
        Category updatedCategory
    ) throws NoSuchElementException {
        Category category = this.repository.findById(id).get();

        category.setName(updatedCategory.getName());

        category = this.repository.save(category);

        return category;
    }

    public void deleteCategory(
        Long id
    ) throws NoSuchElementException {
        Category category = this.repository.findById(id).get();
        
        this.repository.delete(category);
    }

}
