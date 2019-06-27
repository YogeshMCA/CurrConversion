package com.example.microservice.CurrencyConversionService.Bean;

import java.io.Serializable;
import java.util.List;

public class StudentInfo implements Serializable{
	
	private Long sId;
	private String name;
	private List<School> school;
	
	public StudentInfo() {
		
	}
	
	public Long getsId() {
		return sId;
	}
	public void setsId(Long sId) {
		this.sId = sId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<School> getSchool() {
		return school;
	}
	public void setSchool(List<School> school) {
		this.school = school;
	}
	
	
}
