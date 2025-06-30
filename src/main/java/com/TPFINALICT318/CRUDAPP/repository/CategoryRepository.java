package com.TPFINALICT318.CRUDAPP.repository;


import com.TPFINALICT318.CRUDAPP.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
