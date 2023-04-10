package com.springInterceptor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springInterceptor.entity.ProductEntity;
import com.springInterceptor.service.ProductService;

@RestController
@RequestMapping("/inter")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<ProductEntity> findData(){
		return productService.getProductDetails();
	}
	
	@PostMapping
	public ProductEntity saveDetails(@RequestBody ProductEntity enti) {
		return productService.saveData(enti);
	}
 
	@GetMapping("{id}")
	public ResponseEntity<ProductEntity> getById(@PathVariable int id){
		return productService.getDataById(id);
	}
}
