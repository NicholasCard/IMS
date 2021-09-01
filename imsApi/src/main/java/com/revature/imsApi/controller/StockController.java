package com.revature.imsApi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.imsApi.manager.StockManager;
import com.revature.imsApi.model.Stock;


@RestController
@RequestMapping("/transactions")
public class StockController {
	
	@Autowired
	private StockManager manager;
	
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
		return manager.findAll();
	}
	
	
	
}
