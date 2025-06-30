package com.TPFINALICT318.CRUDAPP.controller;

import com.TPFINALICT318.CRUDAPP.model.Category;
import com.TPFINALICT318.CRUDAPP.service.CategoryService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getAllCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("activePage", "categories");
        return "categories";
    }

    @GetMapping("/new")
    public String showCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("activePage", "categories");
        return "categoryForm";
    }

    @PostMapping
    public String createCategory(@ModelAttribute Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories?success=true";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Category category = categoryService.getCategoryById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
        model.addAttribute("category", category);
        model.addAttribute("activePage", "categories");
        return "categoryForm";
    }

    @PostMapping("/update")
    public String updateCategory(@Valid @ModelAttribute Category category, BindingResult result, Model model) {
        System.out.println("Category ID: " + category.getIdCategory() + ", Name: " + category.getNomCategory());
        if (result.hasErrors()) {
            System.out.println("Errors: " + result.getAllErrors());
            model.addAttribute("activePage", "categories");
            return "categoryForm";
        }
        categoryService.saveCategory(category);
        return "redirect:/categories?success=true";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}