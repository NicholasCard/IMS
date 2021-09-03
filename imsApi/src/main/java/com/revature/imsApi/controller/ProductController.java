package com.revature.imsApi.controller;

import com.revature.imsApi.manager.ProductManagerImpl;
import com.revature.imsApi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.imsApi.manager.ProductManager;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductManager manager;

	@Autowired
	public void setManager(ProductManagerImpl manager) {this.manager = manager;}



//	@CrossOrigin(origins = "http://localhost:4200")
//	@GetMapping(produces = "application/json")
//	public String saySomething() {
//		System.out.println("ive been called");
//		return "heyo";
//	}

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

	@GetMapping(path="/test")
	public ResponseEntity<Optional<Product>> getProductById() {
		Optional<Product> test = manager.getProductById(1);
		return new ResponseEntity<Optional<Product>>(manager.getProductById(1), HttpStatus.OK);
	}

}