package com.revature.imsApi.manager;

import java.util.List;
import java.util.Optional;

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

	private static final Logger LOGGER = LogManager.getLogger(ProductManagerImpl.class);

	public ProductManagerImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	// Setter injection
	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

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

	@Override
	public List<Product> findByCategory(String category) {
		return productDao.findByCategory(category);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Product save(int id, int quantity) {
		Product p = productDao.getById(id);
		p.setProductQuantity(p.getProductQuantity() + quantity);
		return productDao.save(p);
	}
	
	@Override
	public Optional<Product> getProductById(int id) {
		return productDao.findById(id);
	}
}
