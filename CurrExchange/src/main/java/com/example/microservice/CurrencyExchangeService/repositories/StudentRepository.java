package com.example.microservice.CurrencyExchangeService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.example.microservice.CurrencyExchangeService.bean.Student;

public interface StudentRepository extends Repository<Student,Long>{
	public List<Student> findBySId(Long sId);
	public Student save(Student student);
	@Query("select max(s.sId) from Student s")
	public Long getMaxsId();
	
	@Query("select max(s.slId) from School s")
	public Long getMaxslId();
}
