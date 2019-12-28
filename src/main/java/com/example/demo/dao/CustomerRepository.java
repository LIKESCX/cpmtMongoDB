package com.example.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.dto.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	 public Customer findByDevcMac(String devcMac);
 
}
