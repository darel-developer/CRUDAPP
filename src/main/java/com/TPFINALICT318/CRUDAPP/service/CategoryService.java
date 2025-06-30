package com.TPFINALICT318.CRUDAPP.service;

import com.TPFINALICT318.CRUDAPP.model.Category;
import com.TPFINALICT318.CRUDAPP.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(String id) {
        return categoryRepository.findById(id);
    }

    public Category saveCategory(Category category) {
        if (category.getIdCategory() != null && categoryRepository.existsById(category.getIdCategory())) {
            // Charger la catégorie existante avec ses produits
            Category existingCategory = categoryRepository.findById(category.getIdCategory())
                    .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
            // Mettre à jour uniquement le nom
            existingCategory.setNomCategory(category.getNomCategory());
            // Sauvegarder la catégorie existante (la collection produits reste intacte)
            return categoryRepository.save(existingCategory);
        } else {
            // Création d'une nouvelle catégorie
            return categoryRepository.save(category);
        }
    }

    public void deleteCategory(String id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        optionalCategory.ifPresent(categoryRepository::delete);
    }
}
