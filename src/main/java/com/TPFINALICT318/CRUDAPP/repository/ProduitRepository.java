package com.ict.tp_exam.repository;

import com.ict.tp_exam.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProduitRepository extends JpaRepository<Produit, UUID> {
}
