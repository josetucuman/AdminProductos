package com.vyjsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vyjsoft.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
