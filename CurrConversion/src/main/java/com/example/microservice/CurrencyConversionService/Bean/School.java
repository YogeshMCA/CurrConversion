package com.example.microservice.CurrencyConversionService.Bean;

import java.io.Serializable;

public class School implements Serializable{
	private Long slId;
	private String name;
	private String address;
	
	public School() {
		
	}
	public Long getSlId() {
		return slId;
	}
	public void setSlId(Long slId) {
		this.slId = slId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
