package com.revature.imsApi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.imsApi.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

	List<Product> findByCategory(String category);

	String findDistinctByCategory(String category);

	@Query(value = "SELECT DISTINCT category FROM ims.product WHERE category LIKE :category%", 
			  nativeQuery = true)
	List<String> findDistinctCategories(@Param("category") String category);
	
}

