package com.revature.imsApi.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.revature.imsApi.dao.ProductDao;

@Service
public class ProductManagerImpl implements ProductManager {
	
	ProductDao productDao;
	private static final Logger LOGGER = LogManager.getLogger(ProductManagerImpl.class);
	
	public ProductManagerImpl(ProductDao productDao) {
		this.productDao = productDao;
	}
}
