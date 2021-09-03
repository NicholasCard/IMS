package com.revature.imsApi.manager;

import com.revature.imsApi.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductManager {

    List<Product> getAllProducts();

    Product create(Product p);

    Optional<Product> getProductById(int id);

}
