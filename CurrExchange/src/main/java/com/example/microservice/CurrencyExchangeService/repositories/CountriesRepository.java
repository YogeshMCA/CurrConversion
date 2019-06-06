package com.example.microservice.CurrencyExchangeService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.example.microservice.CurrencyExchangeService.bean.Countries;

public interface CountriesRepository extends Repository<Countries,Long>{

	@Query("select c from Countries c where c.countryCode in (?,?)")
	public List<Countries> fetchExValueBetwnCon(String from,String to);
}
