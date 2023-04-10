package com.springInterceptor.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springInterceptor.entity.ProductEntity;
import com.springInterceptor.repository.ProductRepositoty;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepositoty productRepository;
	
	public List<ProductEntity> getProductDetails() {
		return productRepository.findAll();
	}

	public ProductEntity saveData(ProductEntity enti) {
		return productRepository.save(enti);
	}
	
	public ResponseEntity<ProductEntity> getDataById(int id){
	 ProductEntity entity = productRepository.findById(id).orElseThrow(()->new ConfigDataResourceNotFoundException(null));
		return ResponseEntity.ok(entity);
	}
	
}
