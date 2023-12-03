package com.henandoweb.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henandoweb.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
