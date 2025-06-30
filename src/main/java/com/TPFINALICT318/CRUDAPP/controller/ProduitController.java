package com.TPFINALICT318.CRUDAPP.controller;

import com.TPFINALICT318.CRUDAPP.model.Produit;
import com.TPFINALICT318.CRUDAPP.service.CategoryService;
import com.TPFINALICT318.CRUDAPP.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/produits")
public class ProduitController {
    @Autowired
    private ProduitService produitService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getAllProduits(Model model) {
        List<Produit> produits = produitService.getAllProduits();
        model.addAttribute("produits", produits);
        model.addAttribute("success", model.containsAttribute("success"));
        model.addAttribute("activePage", "produits");
        return "produits";
    }

    @GetMapping("/new")
    public String showProduitForm(Model model) {
        model.addAttribute("produit", new Produit());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("activePage", "produits");
        return "produitForm";
    }

    @PostMapping
    public String createProduit(@ModelAttribute Produit produit) {
        produitService.saveProduit(produit);
        return "redirect:/produits?success=true";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable UUID id, Model model) {
        Produit produit = produitService.getProduitById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        model.addAttribute("produit", produit);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("activePage", "produits");
        return "produitForm";
    }

    @PostMapping("/update")
    public String updateProduit(@ModelAttribute Produit produit) {
        produitService.saveProduit(produit);
        return "redirect:/produits?success=true";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduit(@PathVariable UUID id) {
        produitService.deleteProduit(id);
        return "redirect:/produits";
    }
}