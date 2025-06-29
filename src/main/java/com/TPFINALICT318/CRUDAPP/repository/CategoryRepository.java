package com.ict.tp_exam.repository;

import com.ict.tp_exam.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
