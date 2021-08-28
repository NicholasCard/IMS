package com.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.manager.StockManager;

@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping("/stocks")
public class StockController {

	@Autowired
	private StockManager stockManager;

	private static final Logger logger = LogManager.getLogger(StockController.class);
}
