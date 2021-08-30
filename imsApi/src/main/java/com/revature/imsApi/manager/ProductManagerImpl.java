package com.revature.imsApi.manager;

import com.revature.imsApi.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.imsApi.dao.ProductDao;

import java.util.List;

@Service
public class ProductManagerImpl implements ProductManager {
	
	ProductDao productDao;

	private static final Logger LOGGER = LogManager.getLogger(ProductManagerImpl.class);


	// Setter injection
	@Autowired
	public void setProductDao(ProductDao productDao) {this.productDao = productDao;}

	public ProductManagerImpl() {
		super();
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Product create(Product p) {
		return productDao.save(p);
	}
}
