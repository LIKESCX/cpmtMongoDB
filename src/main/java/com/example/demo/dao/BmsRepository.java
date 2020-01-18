package com.example.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.dto.Customer;

public interface BmsRepository extends MongoRepository<Customer, String> {//是去mydb库下的集合名称为cutomer中查找，所以注意对应的mongodb下的mydb数据库中的集合名称必须是customer，否则查询出来的为null
	
 
}
