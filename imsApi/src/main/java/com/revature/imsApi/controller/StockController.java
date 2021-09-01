package com.revature.imsApi.controller;

import java.util.List;

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
import com.revature.imsApi.model.StockType;


@RestController
@RequestMapping("/stocks")
public class StockController {
	
	@Autowired
	private StockManager stockManager;
	@Autowired
	private ProductManager productManager;
	
	/*
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(produces = "application/json")
	public String saySomething() {
		System.out.println("ive been called");
		return "heyo";
	}
	*/
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(produces="application/json")
	public List<Stock> getAllStock(){
		return stockManager.findAll();
	}
	
	//add product_stock
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Product create(@RequestBody Stock s) {
		
		stockManager.create(s);
		int id = s.getProductId();
		int quantity = s.getQuantity();
		if (s.getTransactionType() == StockType.OUT) {
			quantity = quantity * -1;
		}
		return productManager.save(id, quantity);
	}
	
	
	
}
