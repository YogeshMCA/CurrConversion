package com.example.microservice.CurrencyExchangeService.repositories;

import org.springframework.data.repository.Repository;
import com.example.microservice.CurrencyExchangeService.bean.School;

public interface SchoolRepository extends Repository<School,Long>{
	public void delete(School school);
}
