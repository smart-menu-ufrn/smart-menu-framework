package br.edu.ufrn.smartmenu.categories.controllers;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufrn.smartmenu.categories.models.Category;
import br.edu.ufrn.smartmenu.categories.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> responseDTOList = service.getAllCategories();

        return ResponseEntity.status(HttpStatus.OK).body(responseDTOList);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(
        @RequestBody Category category
    ) {
        category = service.createCategory(category);

        URI location = URI.create("/items/categories/" + category.getId());

        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(
        @PathVariable Long id
    ) {
        try {
            Category category = service.getCategoryById(id);

            return ResponseEntity.status(HttpStatus.OK).body(category);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(
        @PathVariable Long id,
        @RequestBody Category category
    ) {
        try {
            category = service.updateCategory(id, category);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(category);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        try {
            service.deleteCategory(id);
            
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
