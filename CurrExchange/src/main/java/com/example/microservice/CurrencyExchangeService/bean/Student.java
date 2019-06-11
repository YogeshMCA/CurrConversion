package com.example.microservice.CurrencyExchangeService.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name="student",table="SEQ_TABLE",pkColumnName="TBL_NAME",valueColumnName="TBL_SEQ",initialValue=103,allocationSize=1)
public class Student implements Serializable{
	
	@Id
	@GeneratedValue(generator="student",strategy=GenerationType.TABLE)
	private Long sId;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true) //orphanRemoval - This will remove the child records, when the parent records get removed
	@JoinColumn(name="sId") //Avoid storing null value for foreign key column in child table.
	private List<School> school;
	
	public Student(){
		
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
