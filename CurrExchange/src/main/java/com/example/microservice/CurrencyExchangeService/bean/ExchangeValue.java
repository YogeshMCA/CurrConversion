package com.example.microservice.CurrencyExchangeService.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class ExchangeValue implements Serializable{
@Column(name="from_code")
private String fromCode;
@Column(name="to_code")
private String toCode;
@Id
private Long id;
private BigDecimal conversionMultiple;
private int port;

/*@OneToMany(mappedBy="exchangeValue")
Set<Countries> countries;*/

@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn()
private Countries countries;

public ExchangeValue(){
	
}
public ExchangeValue(String from, String to, Long id, BigDecimal conversionMultiple) {
	super();
	this.fromCode = from;
	this.toCode = to;
	this.id = id;
	this.conversionMultiple = conversionMultiple;
}

public String getFromCode() {
	return fromCode;
}
public void setFromCode(String fromCode) {
	this.fromCode = fromCode;
}
public String getToCode() {
	return toCode;
}
public void setToCode(String toCode) {
	this.toCode = toCode;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public BigDecimal getConversionMultiple() {
	return conversionMultiple;
}
public void setConversionMultiple(BigDecimal conversionMultiple) {
	this.conversionMultiple = conversionMultiple;
}
public int getPort() {
	return port;
}
public void setPort(int port) {
	this.port = port;
}


}
