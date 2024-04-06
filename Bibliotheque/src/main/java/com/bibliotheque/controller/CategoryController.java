package com.bibliotheque.controller;

import com.bibliotheque.exception.RessourcesNotFoundException;
import com.bibliotheque.model.Category;
import com.bibliotheque.model.Document;
import com.bibliotheque.repository.CategoryRepository;
import com.bibliotheque.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RequestMapping("/categories")
@RestController
@AllArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category>getAllCategory(Category category){

        return  categoryRepository.findAll();
    }

    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category){
        return  this.categoryService.addCategory(category);
    }
    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable("id") Integer id, @RequestBody Category updateCategory){
        return  this.categoryService.updateCategory(id,updateCategory);

    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RessourcesNotFoundException("document not exit with id :" +id));
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Integer id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RessourcesNotFoundException("document not exit with id :" +id));
        categoryRepository.delete(category);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
