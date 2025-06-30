package com.TPFINALICT318.CRUDAPP;

import com.TPFINALICT318.CRUDAPP.model.Produit;
import com.TPFINALICT318.CRUDAPP.service.CategoryService;
import com.TPFINALICT318.CRUDAPP.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        List<?> allCategories = categoryService.getAllCategories();
        List<Produit> allProduits = produitService.getAllProduits();

        // Journalisation pour débogage 
        System.out.println("Nombre de catégories: " + allCategories.size());
        System.out.println("Nombre de produits: " + (allProduits != null ? allProduits.size() : "null"));

        var lastCategories = allCategories.stream()
                .skip(Math.max(0, allCategories.size() - 3))
                .toList();

        var lastProduits = allProduits != null ? allProduits.stream()
                .skip(Math.max(0, allProduits.size() - 3))
                .toList() : List.of();

        Map<String, Integer> produitParCategorie = new LinkedHashMap<>();
        categoryService.getAllCategories().forEach(cat -> {
            int count = (cat.getProduits() != null) ? cat.getProduits().size() : 0;
            produitParCategorie.put(cat.getNomCategory(), count);
        });

        // Calcul de la valeur totale avec gestion des cas null
        double totalValue = 0.0;
        if (allProduits != null && !allProduits.isEmpty()) {
            totalValue = allProduits.stream()
                    .filter(produit -> produit.getPrixProduit() != null)
                    .mapToDouble(Produit::getPrixProduit)
                    .sum();
        }
        System.out.println("Valeur totale calculée: " + totalValue);

        model.addAttribute("categoryCount", allCategories.size());
        model.addAttribute("produitCount", allProduits != null ? allProduits.size() : 0);
        model.addAttribute("totalValue", totalValue);
        model.addAttribute("categories", lastCategories);
        model.addAttribute("produits", lastProduits);
        model.addAttribute("produitParCategorie", produitParCategorie);
        model.addAttribute("activePage", "dashboard");

        return "dashboard";
    }
}