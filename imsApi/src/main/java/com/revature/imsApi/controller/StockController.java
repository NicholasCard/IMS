package com.revature.imsApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.imsApi.manager.ProductManager;
import com.revature.imsApi.manager.StockManager;
import com.revature.imsApi.model.Product;
import com.revature.imsApi.model.Stock;


@RestController
@RequestMapping("/transactions")
public class StockController {
	
	@Autowired
	private StockManager stockManager;
	@Autowired
	private ProductManager productManager;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(produces="application/json")
	public List<Stock> getAllStock(){
		return stockManager.findAll();
	}
	
	//add product_stock
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Optional<Product> create(@RequestBody Stock s) {
		
		stockManager.create(s);
		int id = s.getProductId();
		
		return productManager.getProductById(id);
	}
	
	
	
}
