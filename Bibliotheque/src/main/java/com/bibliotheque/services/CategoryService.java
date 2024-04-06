package com.bibliotheque.services;

import com.bibliotheque.exception.RessourcesNotFoundException;
import com.bibliotheque.model.Category;
import com.bibliotheque.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@Service

public class CategoryService {
    private CategoryRepository categoryRepository;
    public  Category addCategory(Category category){
        Category category1 = new Category();
        category1.setNom(category.getNom());
        category1.setCouleur(category.getCouleur());

        return this.categoryRepository.save(category1);
    }

    public Category updateCategory(Integer id, @RequestBody Category categoryDetails){
        Category updateCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RessourcesNotFoundException("document not exit with id :" +id));

        updateCategory.setNom(categoryDetails.getNom());
        updateCategory.setCouleur(categoryDetails.getCouleur());

        return this.categoryRepository.save(updateCategory);
    }
}
