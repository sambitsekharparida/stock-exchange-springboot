package com.iiht.fse2.service;

import com.iiht.fse2.dto.Stock;
import com.iiht.fse2.model.StockExchange;

public interface StockExchangeService {

	public StockExchange addStockDetails(Stock stock);
	
	public String getLatestPrice(String code);
	
	public String removeStock(String companyCode);
}
