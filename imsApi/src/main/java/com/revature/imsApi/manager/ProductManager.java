package com.revature.imsApi.manager;

import java.util.List;

import com.revature.imsApi.model.Product;

public interface ProductManager {

	List<Product> findByCategory(String category);

	List<Product> findAll();

}
