package com.example.microservice.CurrencyExchangeService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.example.microservice.CurrencyExchangeService.bean.ExchangeValue;

public interface ExchangeValueRepository extends Repository<ExchangeValue, Long>{
	ExchangeValue findByFromAndTo(String from,String to);
	@Query("select e.from as from,e.to as to from ExchangeValue e where e.from=?")
	List<ExchangeValue> findFromAndToByFrom(String from);
}
