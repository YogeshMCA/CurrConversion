package com.example.microservice.CurrencyExchangeService.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Countries {
	
	@Id
	private Long Id;
	private String countryCode;
	private String countryName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumns({@JoinColumn(name="fromCode",referencedColumnName="from_code"),
					@JoinColumn(name="toCode",referencedColumnName="to_code")})
	private ExchangeValue exchangeValue;
	
	@JsonIgnore
	public ExchangeValue getExchangeValue() {
		return exchangeValue;
	}
	public void setExchangeValue(ExchangeValue exchangeValue) {
		this.exchangeValue = exchangeValue;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	

}
