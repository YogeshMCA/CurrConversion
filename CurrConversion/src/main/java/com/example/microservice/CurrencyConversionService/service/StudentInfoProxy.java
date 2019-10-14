package com.example.microservice.CurrencyConversionService.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservice.CurrencyConversionService.Bean.StudentInfo;

//@FeignClient("netflix-zuul")
@FeignClient("CURR-EXCHANGE")
public interface StudentInfoProxy {
	/*Enable it  for Zuul
	 * 
	 * @GetMapping("/curr-exchange/student-info/{id}")
	public List<StudentInfo> getStudentInfo(@PathVariable("id") String id);*/
	
	@GetMapping("/student-info/{id}")
	public List<StudentInfo> getStudentInfo(@PathVariable("id") String id);
}
