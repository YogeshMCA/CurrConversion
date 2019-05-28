package com.example.microservice.CurrencyExchangeService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.example.microservice.CurrencyExchangeService.bean.ExchangeValue;

public interface ExchangeValueRepository extends Repository<ExchangeValue, Long>{
	ExchangeValue findByFromCodeAndToCode(String from,String to);
	@Query("select e from ExchangeValue e where e.fromCode=? and e.toCode=?")
	List<ExchangeValue> fetchExchangeValueData(String from,String to);
}
