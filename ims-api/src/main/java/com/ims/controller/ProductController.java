package com.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.manager.ProductManager;

@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductManager productManager;
	
	private static final Logger logger = LogManager.getLogger(ProductController.class);
}
