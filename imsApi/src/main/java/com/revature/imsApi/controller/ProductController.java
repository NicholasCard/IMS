package com.revature.imsApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.imsApi.manager.ProductManager;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductManager manager;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(produces = "application/json")
	public String saySomething() {
		System.out.println("ive been called");
		return "heyo";
	}

}