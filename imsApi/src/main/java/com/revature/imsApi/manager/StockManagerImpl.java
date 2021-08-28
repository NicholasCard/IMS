package com.revature.imsApi.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.revature.imsApi.dao.StockDao;

@Service
public class StockManagerImpl implements StockManager{

	StockDao stockDao;
	private static final Logger LOGGER = LogManager.getLogger(StockManagerImpl.class);
	
	public StockManagerImpl (StockDao stockDao) {
		this.stockDao = stockDao;
	}
}
