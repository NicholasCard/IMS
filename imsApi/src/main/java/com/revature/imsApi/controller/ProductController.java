package com.revature.imsApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.imsApi.manager.ProductManager;
import com.revature.imsApi.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductManager manager;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/{category}", produces="application/json")
	public List<Product> findByCategory(@PathVariable String category) {
		return manager.findByCategory(category);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(produces="application/json")
	public List<Product> findAll() {
		return manager.findAll();
	}
	
	// get all products
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping
		public ResponseEntity<List<Product>> getAllProducts() {
			List<Product> products = manager.getAllProducts();
			return new ResponseEntity<>(products, HttpStatus.OK);
	 	}

		// create product
		@CrossOrigin(origins="http://localhost:4200")
		@PostMapping(consumes = "application/json", produces = "application/json")
		public Product create(@RequestBody Product p) {
			return manager.create(p);
		}
}