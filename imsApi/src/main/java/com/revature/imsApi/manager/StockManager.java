package com.revature.imsApi.manager;

import java.util.List;

import com.revature.imsApi.model.Stock;

public interface StockManager {

	List<Stock> findAll();

	Stock create(Stock s);
}
