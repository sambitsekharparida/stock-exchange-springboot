package com.iiht.fse2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iiht.fse2.model.StockExchange;

@Repository
public interface StockExchangeRepo extends JpaRepository<StockExchange, Integer>{

	List<StockExchange> findFirstByCodeOrderByStockIdDesc(String code);
	
	@Modifying
	@Query("DELETE FROM StockExchange s WHERE s.code = ?1")
	Integer deleteStocks(String code);

}
