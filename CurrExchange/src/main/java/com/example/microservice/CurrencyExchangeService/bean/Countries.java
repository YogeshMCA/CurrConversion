package com.example.microservice.CurrencyExchangeService.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Countries implements Serializable{
	
	@Id
	private Long Id;
	private String countryCode;
	private String countryName;
	
	/*@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumns({@JoinColumn(name="fromCode",referencedColumnName="from_code"),
					@JoinColumn(name="toCode",referencedColumnName="to_code")})
	private ExchangeValue exchangeValue;
	*/
	
	@OneToMany(mappedBy="countries")
	private Set<ExchangeValue> exchangeValue;
			
	public Set<ExchangeValue> getExchangeValue() {
		return exchangeValue;
	}
	public void setExchangeValue(Set<ExchangeValue> exchangeValue) {
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
