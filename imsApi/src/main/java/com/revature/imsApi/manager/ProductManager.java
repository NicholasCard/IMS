package com.revature.imsApi.manager;

import com.revature.imsApi.model.Product;

import java.util.List;

public interface ProductManager {

    List<Product> getAllProducts();

    Product create(Product p);

}
