package com.ict.tp_exam.controller;

import com.ict.tp_exam.model.Category;
import com.ict.tp_exam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


}
