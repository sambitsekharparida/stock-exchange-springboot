package com.iiht.fse2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.fse2.dto.Stock;
import com.iiht.fse2.model.StockExchange;
import com.iiht.fse2.service.StockExchangeServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping(path = "/api/v1.0/stock")
public class StockExchangeController {
	
	@Autowired
	private StockExchangeServiceImpl stockExchangeService;
	
	@Autowired
	private KafkaTemplate<String, Object> template;
	
	/**
	 * 'POST' request handler to save new company details and stock price
	 * @param code - company code
	 * @param price - current stock price
	 * @return StockExchange
	 */
	@PostMapping(value = "/add")
	public StockExchange register(@RequestBody Stock stock) {
		log.info("Adding Stock Price For a Company.");
		return stockExchangeService.addStockDetails(stock);
	}
	
	/**
	 * 'GET' request handler to get Latest stock price for a company
	 * @param code - company code
	 * @return String - Stock Price
	 */
	@GetMapping(value = "/stockPrice/{code}")
	public String getLatestStockPrice(@PathVariable String code) {
		log.info("Retriving Latest Stock Price of a Company.");
		return stockExchangeService.getLatestPrice(code);
	}
	
	/**
	 * 'DELETE' request handler to remove company details from DB
	 * @param companyCode
	 * @return String
	 */
	@DeleteMapping("/removeStock/{code}")
	public String removeStockDetails(@PathVariable("code") String code) {
		log.info("Removing Stock Price of a Company.");
		return stockExchangeService.removeStock(code);
	}
	
	@GetMapping(value = "/publish/stockPrice/{code}")
	public String getAllStockPrice(@PathVariable String code) {
		String price = stockExchangeService.getLatestPrice(code);
		template.send("stock", "Price : "+ code +  ":" + price);
		return price;
	}
	
	@GetMapping(value = "/publishJson")
	public String publish(@PathVariable String code) {
		String price = stockExchangeService.getLatestPrice(code);
		template.send("stock", new StockExchange().setCode(code).setPrice(Double. valueOf(price)));
		return price;
	}
	
}
