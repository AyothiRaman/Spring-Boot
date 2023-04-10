package com.springInterceptor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springInterceptor.entity.ProductEntity;

@Repository
public interface ProductRepositoty  extends JpaRepository<ProductEntity, Integer>{


}
