package com.example.microservice.CurrencyConversionService.Controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Recover;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microservice.CurrencyConversionService.Bean.CurrencyConversionBean;
import com.example.microservice.CurrencyConversionService.Bean.StudentInfo;
import com.example.microservice.CurrencyConversionService.service.CurrencyExchangeProxy;
import com.example.microservice.CurrencyConversionService.service.StudentInfoProxy;
import com.example.microservice.CurrencyConversionService.service.StudentService;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@Autowired
	private StudentInfoProxy stdProxy;
	
	@Autowired
	private StudentService studentService;
	
	//RestTemplate - To communicate other services
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convert(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity){
		
		Map<String,String> val = new  HashMap<>();
		val.put("from", from);
		val.put("to", to);
		ResponseEntity<CurrencyConversionBean> response = new RestTemplate().getForEntity(
				"http://localhost:8000/exchange-service/from/{from}/to/{to}",CurrencyConversionBean.class,val);
		CurrencyConversionBean ccBean = response.getBody();
		
		return new CurrencyConversionBean(ccBean.getId(), ccBean.getFrom(),ccBean.getTo(),quantity,ccBean.getConversionMultiple(),ccBean.getConversionMultiple().multiply(quantity),0);
	}
	
	//Feign - To communicate other services in an easiest way
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean feignConvert(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity){
		
		CurrencyConversionBean ccBean = proxy.getExchangeValue(from, to);
		return new CurrencyConversionBean(ccBean.getId(), ccBean.getFrom(),ccBean.getTo(),quantity,ccBean.getConversionMultiple(),ccBean.getConversionMultiple().multiply(quantity),ccBean.getPort());
	}
	
	
	
	@GetMapping("/student-info-feign/{Id}")
	public List<StudentInfo> studentInfo(@PathVariable String Id){
		
		List<StudentInfo> stdInfo = stdProxy.getStudentInfo(Id);
		return stdInfo;
	}
	
	@GetMapping("/student-info-feign-retry/{Id}")
	public String studentInfoRetry(@PathVariable String Id) {
		System.out.println("====="+stdProxy.hashCode());
		return studentService.getInfo(Id);
	}
	
}
