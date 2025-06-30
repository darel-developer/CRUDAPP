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
		model.addAttribute("categoryCount", categoryService.getAllCategories().size());
		model.addAttribute("produitCount", produitService.getAllProduits().size());
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("produits", produitService.getAllProduits());
		model.addAttribute("activePage", "dashboard");
		return "dashboard"; // Le nom du fichier HTML dans /resources/templates
	}
}
