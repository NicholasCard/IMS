package com.revature.imsApi.manager;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.revature.imsApi.dao.StockDao;
import com.revature.imsApi.model.Stock;

@Service
public class StockManagerImpl implements StockManager{

	StockDao stockDao;
	private static final Logger LOGGER = LogManager.getLogger(StockManagerImpl.class);
	
	public StockManagerImpl (StockDao stockDao) {
		this.stockDao = stockDao;
	}

	@Override
	public List<Stock> findAll() {
		return stockDao.findAll();
	}
	

	@Override
	public Stock create (Stock s) {
		return stockDao.save(s);

	}
}
