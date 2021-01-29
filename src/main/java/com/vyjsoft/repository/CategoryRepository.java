package com.vyjsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vyjsoft.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
