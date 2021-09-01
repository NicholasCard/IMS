package com.revature.imsApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.imsApi.manager.ProductManager;
import com.revature.imsApi.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductManager productManager;

//	@CrossOrigin(origins = "http://localhost:4200")
//	@GetMapping(produces = "application/json")
//	public String saySomething() {
//		System.out.println("ive been called");
//		return "heyo";
//	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/{category}", produces="application/json")
	public List<Product> findByCategory(@PathVariable String category) {
		return productManager.findByCategory(category);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(produces="application/json")
	public List<Product> findAll() {
		return productManager.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/ctgry/{ctgry}", produces="application/json")
	public List<String> findDistinctCategories(@PathVariable String ctgry) {
		return productManager.findDistinctCategories(ctgry);
	}
	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@GetMapping(path="/category/{category}", produces="application/json")
//	public String findDistinctByCategory(@PathVariable String category) {
//		return productManager.findDistinctByCategory(category);
//	}
}