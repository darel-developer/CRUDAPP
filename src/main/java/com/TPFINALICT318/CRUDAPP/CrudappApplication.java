package com.TPFINALICT318.CRUDAPP;

import com.TPFINALICT318.CRUDAPP.service.CategoryService;
import com.TPFINALICT318.CRUDAPP.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class CrudappApplication {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProduitService produitService;

	public static void main(String[] args) {
		SpringApplication.run(CrudappApplication.class, args);
	}

	@GetMapping("/")
	public String home(Model model) {
		var allCategories = categoryService.getAllCategories();
		var allProduits = produitService.getAllProduits();

		var lastCategories = allCategories.stream()
				.skip(Math.max(0, allCategories.size() - 3))
				.toList();

		var lastProduits = allProduits.stream()
				.skip(Math.max(0, allProduits.size() - 3))
				.toList();

		model.addAttribute("categoryCount", allCategories.size());
		model.addAttribute("produitCount", allProduits.size());
		model.addAttribute("categories", lastCategories);
		model.addAttribute("produits", lastProduits);
		model.addAttribute("activePage", "dashboard");
		return "dashboard";
	}
}
