package com.iiht.fse2.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.iiht.fse2.dto.Stock;
import com.iiht.fse2.model.StockExchange;
import com.iiht.fse2.repository.StockExchangeRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Component
@Transactional
public class StockExchangeServiceImpl implements StockExchangeService{

	@Autowired
	private StockExchangeRepo stockExchangeRepo;
	
	
	@Override
	public String getLatestPrice(String code) {

		log.debug(code);
		String price = null;

		List<StockExchange> stockExchange = stockExchangeRepo.findFirstByCodeOrderByStockIdDesc(code);

		for (StockExchange stock : stockExchange) {
			price = String.valueOf(stock.getPrice());
		}

		return price;
	}

	@Override
	public String removeStock(String companyCode) {
		int status = stockExchangeRepo.deleteStocks(companyCode);
		if(status != 0) {
			log.debug("Removed Stock Details for "+ companyCode);
			return "Successfully Removed Stock Details";
		}
		
		return "Error while removing Stock Details";
	}

	@Override
	public StockExchange addStockDetails(Stock stock) {

		// updateStocks();
		// return new StockExchange();
		StockExchange stockExchange = new StockExchange();
		stockExchange.setCode(stock.getCode());
		stockExchange.setPrice(Double.parseDouble(stock.getPrice()));
		stockExchange.setDate(LocalDate.now());
		stockExchange.setTime(LocalTime.now());

		return stockExchangeRepo.save(stockExchange);

	}

	public void updateStocks() {
		List<StockExchange> list = new ArrayList<>();
		
		list.add(new StockExchange().setCode("ICICI").setPrice(1478.55).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ICICI").setPrice(1478.99).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ICICI").setPrice(1477.21).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ICICI").setPrice(1477.01).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ICICI").setPrice(1476.49).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ICICI").setPrice(1477.31).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ICICI").setPrice(1477.33).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ICICI").setPrice(1477.50).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ICICI").setPrice(1478.01).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ICICI").setPrice(1478.27).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ICICI").setPrice(1479.00).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ICICI").setPrice(1478.44).setDate(LocalDate.now()).setTime(LocalTime.now()));
		
		list.add(new StockExchange().setCode("RELIANCE").setPrice(2595.55).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("RELIANCE").setPrice(2595.99).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("RELIANCE").setPrice(2596.21).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("RELIANCE").setPrice(2596.01).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("RELIANCE").setPrice(2596.49).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("RELIANCE").setPrice(2596.31).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("RELIANCE").setPrice(2596.33).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("RELIANCE").setPrice(2596.50).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("RELIANCE").setPrice(2595.01).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("RELIANCE").setPrice(2595.27).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("RELIANCE").setPrice(2595.00).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("RELIANCE").setPrice(2595.44).setDate(LocalDate.now()).setTime(LocalTime.now()));
		
		list.add(new StockExchange().setCode("ITC").setPrice(273.55).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ITC").setPrice(273.99).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ITC").setPrice(272.21).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ITC").setPrice(272.01).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ITC").setPrice(272.49).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ITC").setPrice(272.31).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ITC").setPrice(272.33).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ITC").setPrice(272.50).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ITC").setPrice(273.01).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ITC").setPrice(273.27).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ITC").setPrice(273.00).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("ITC").setPrice(273.44).setDate(LocalDate.now()).setTime(LocalTime.now()));
		
		list.add(new StockExchange().setCode("SAIL").setPrice(68.55).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("SAIL").setPrice(68.99).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("SAIL").setPrice(67.21).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("SAIL").setPrice(67.01).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("SAIL").setPrice(67.49).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("SAIL").setPrice(67.31).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("SAIL").setPrice(67.33).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("SAIL").setPrice(67.50).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("SAIL").setPrice(68.01).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("SAIL").setPrice(68.27).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("SAIL").setPrice(68.00).setDate(LocalDate.now()).setTime(LocalTime.now()));
		list.add(new StockExchange().setCode("SAIL").setPrice(68.44).setDate(LocalDate.now()).setTime(LocalTime.now()));
		
		stockExchangeRepo.saveAll(list);
		
	}
}
