package com.ims.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ims.model.Stock;

@Repository
public interface StockDao extends JpaRepository<Stock, Integer>{

}
