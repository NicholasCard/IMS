package com.revature.imsApi.manager;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.imsApi.dao.ProductDao;
import com.revature.imsApi.model.Product;

@Service
public class ProductManagerImpl implements ProductManager {
	
	@Autowired
	private ProductDao productDao;
	
	//private static final Logger LOGGER = LogManager.getLogger(ProductManagerImpl.class);
	
//	public ProductManagerImpl(ProductDao productDao) {
//		this.productDao = productDao;
//	}

	@Override
	public List<Product> findByCategory(String category) {
		return productDao.findByCategory(category);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public String findDistinctByCategory(String category) {
		
		return productDao.findDistinctByCategory(category);
	}

	@Override
	public List<String> findDistinctCategories(String category) {
		
		return productDao.findDistinctCategories(category);
	}
	
	
}
