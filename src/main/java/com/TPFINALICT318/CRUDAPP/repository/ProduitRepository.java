package com.TPFINALICT318.CRUDAPP.repository;

import com.TPFINALICT318.CRUDAPP.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProduitRepository extends JpaRepository<Produit, UUID> {
}
