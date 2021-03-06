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
import java.util.Optional;

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
	@GetMapping(path="/ctgry/{ctgry}", produces="application/json")
	public List<String> findDistinctCategories(@PathVariable String ctgry) {
		return manager.findDistinctCategories(ctgry);
	}
	

	// get all products
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping
		public ResponseEntity<List<Product>> getAllProducts() {
			List<Product> products = manager.getAllProducts();
			return new ResponseEntity<>(products, HttpStatus.OK);
	 	}
	 	
		
		@GetMapping(path="/test")
		public ResponseEntity<Optional<Product>> getProductById() {
			Optional<Product> test = manager.getProductById(1);
			return new ResponseEntity<Optional<Product>>(manager.getProductById(1), HttpStatus.OK);
		}

		// create product
		@CrossOrigin(origins="http://localhost:4200")
		@PostMapping(consumes = "application/json", produces = "application/json")
		public int create(@RequestBody Product p) {
		Product temp = manager.create(p);
		return temp.getProductId();
	}
}