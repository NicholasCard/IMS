package com.revature.imsApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.imsApi.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

	
}

