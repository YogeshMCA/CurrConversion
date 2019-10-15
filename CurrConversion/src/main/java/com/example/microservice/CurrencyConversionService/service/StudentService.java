package com.example.microservice.CurrencyConversionService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentInfoProxy studentInfoProxy;
	
	/*
	 * Whenever the specified exception get thrown from the method, then only the retry function will work.
	 * Same as for @Recover, if the specified exception get thrown, the fallback method will execute  
	 */
	@Retryable(value={RuntimeException.class},maxAttempts=3,backoff=@Backoff(delay=1000)) 
	public String getInfo(String id) {
		System.out.println("============");
		//int i =Integer.valueOf(id)/(Integer.valueOf(id)-1);
		studentInfoProxy.getStudentInfo(id);
		return "Returning from Service class";
	}
	
	@Recover
	public String fallBack(ArrayIndexOutOfBoundsException e){
		return "Fallback Method";
	}

}
