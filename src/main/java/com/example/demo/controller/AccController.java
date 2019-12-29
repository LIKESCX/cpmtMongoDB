package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dto.Customer;
import com.example.demo.impl.AccMgmt;

@Controller
public class AccController {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private AccMgmt accMgmt;
	
	@RequestMapping("/probe/wp")
	@ResponseBody
	public Object wpPhp(HttpServletRequest request,HttpServletResponse response){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date())+"-->prob post begin.......");
		try {
			Enumeration<String> enums = request.getParameterNames();
			while (enums.hasMoreElements()) {
				String name = enums.nextElement();
				System.out.println("data:"+name+"="+request.getParameter(name));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * 根据实体类中的属性进行查询：
		 * 当需要根据实体类中的属性查询时，MongoRepository提供的方法已经不能满足，我们需要在CustomerRepository仓库中定义方法，
		 * 定义方法名的规则为：find + By + 属性名（首字母大写），如：根据设备Mac查询Customer 仓库中添加的方法：
		 */
		
		Customer cus = repository.findByDevcMac("FCE998A1E7EF");
		System.out.println(cus);
		//于上面的findByDevcMac等价 mongoTemplate比MongoRepository语法上更灵活一些。
		Customer cus1=mongoTemplate.findOne(new Query(Criteria.where("devcMac").is("FCE998A1E7EF")), Customer.class);
		System.out.println(cus1);
				System.out.println(sdf.format(new Date())+"-->wphp post end.......");
		
				return "OK";
	}
	
	@RequestMapping("/probe/addCustomer")
	@ResponseBody
	public Object addCustomer() {
		Customer customer = new Customer("141FBA7890E9", "FCE998A1E7EE", "20190612135348", "20190612135401", "8");
		//repository.s
		return "OK";
	}
}
