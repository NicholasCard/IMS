package com.revature.imsApi.manager;

import com.revature.imsApi.model.Stock;

import java.util.List;

public interface StockManager {

    List<Stock> findAll();

    Stock create(Stock s);
}
