package com.example.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dto.Customer;

@Service
public class AccMgmt {
	@Autowired
	private CustomerRepository repository;
	
	public List<Customer> queryAll() throws Exception {
		   return repository.findAll();
		}
}
