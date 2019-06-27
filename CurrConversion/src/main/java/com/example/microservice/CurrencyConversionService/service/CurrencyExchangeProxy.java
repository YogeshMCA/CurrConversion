package com.example.microservice.CurrencyConversionService.service;

import java.math.BigDecimal;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservice.CurrencyConversionService.Bean.CurrencyConversionBean;

//@FeignClient(name="exchange-service",url= "${feign.client.url}")
//@FeignClient("curr-exchange") // 1 -> Name in the eureka server - Communicate with Currency exchange service
@FeignClient("netflix-zuul") // Name in the eureka server - Communicate with Currency exchange service via Zuul proxy
//@RibbonClient("curr-exchange") //Added multiple instances with the exchange-service name in application.properties file for load balancing
public interface CurrencyExchangeProxy {
	// 1-> @GetMapping("/exchange-service/from/{from}/to/{to}")
	@GetMapping("/curr-exchange/exchange-service/from/{from}/to/{to}")
	public CurrencyConversionBean getExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);
	
	
}
