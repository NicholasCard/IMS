package com.revature.imsApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.imsApi.model.Stock;

@Repository
public interface StockDao extends JpaRepository<Stock, Integer>{

	
	
	void updateProductQuantity();

}
