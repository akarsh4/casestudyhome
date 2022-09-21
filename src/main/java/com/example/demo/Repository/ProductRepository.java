package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.controller.products;

public interface ProductRepository extends JpaRepository<products, Long> {

	 }


