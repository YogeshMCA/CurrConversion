package com.example.microservice.CurrencyExchangeService.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@TableGenerator(name="school",table="SEQ_TABLE",pkColumnName="TBL_NAME",valueColumnName="TBL_SEQ",initialValue=204,allocationSize=1)
public class School implements Serializable{
	@Id
	@GeneratedValue(generator="school",strategy=GenerationType.TABLE)
	private Long slId;
	private String name;
	private String address;
	
	
	@ManyToOne
	@JoinColumn(name="sId",insertable = false, updatable = false)
	private Student student;
	
	public School(){
		
	}

	public Long getSlId() {
		return slId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	@JsonIgnore
	public Student getStudent() {
		return student;
	}

	public void setSlId(Long slId) {
		this.slId = slId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
}
