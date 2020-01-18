package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.BmsInfo;
import com.example.demo.dto.ChargingProcessInfoHot;
import com.example.demo.utils.TimeConvertor;

@Controller
public class ChargingProcessInfoHotController {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@RequestMapping("/cpmt/addChargingProcessInfoHot")
	@ResponseBody
	public Object addChargingProcessInfoHot() {
		ChargingProcessInfoHot chargingProcessInfoHot = new ChargingProcessInfoHot();
		chargingProcessInfoHot.setOperatorID("1000918733");
		chargingProcessInfoHot.setStationID("101");
		chargingProcessInfoHot.setEquipmentID("10001");
		chargingProcessInfoHot.setStatus(3);
		chargingProcessInfoHot.setDealStatus(0);
		BmsInfo singleBmsInfo = new BmsInfo();
		singleBmsInfo.setBMSCode("bmsCode001");
		singleBmsInfo.setBMSVer("bmsVer002");
		Date date = new Date();
		String strDate = TimeConvertor.date2String(date, TimeConvertor.FORMAT_MINUS_24HOUR);
		System.out.println(strDate);
		singleBmsInfo.setReceivedTime(date);
		singleBmsInfo.setInTime(date);
		List<BmsInfo> bmsInfo = new ArrayList<BmsInfo>();
		bmsInfo.add(singleBmsInfo);
		chargingProcessInfoHot.setBmsInfo(bmsInfo);
		//插入
		//底层默认以对象名(chargingProcessInfoHot)为集合的名字,进行插入到指定的集合中，若没有此集合，则生成此集合，并插入数据
		//mongoTemplate.insert(chargingProcessInfoHot);
		mongoTemplate.insert(chargingProcessInfoHot, "charging_process_info_hot");//指定集合的名字，插入到指定的集合中，若没有指定的集合，则生成此集合，并插入数据
		//查询inTime = 2020-01-18 15:24:08
		//mongoTemplate.findOne(query, entityClass)
		Query query = new Query();
		query.addCriteria(Criteria.where("bmsInfo.bMSCode").is("bmsCode001").andOperator(Criteria.where("bmsInfo.bMSVer").is("bmsVer002")));
		//若有多个符合要求的文档，findOne()方法只把查到的第一个符合要求的文档返回
		//ChargingProcessInfoHot findChargingProcessInfoHot = mongoTemplate.findOne(query, ChargingProcessInfoHot.class, "charging_process_info_hot");
		
		//andOperator方法中的Criteria类型的参数为可变参数
		//Criteria bmsVer = Criteria.where("bmsInfo.bMSVer").is("bmsVer002");
		//Criteria inTime = Criteria.where("bmsInfo.inTime").is(date);
		//大于等于
		//Criteria inTime = Criteria.where("bmsInfo.inTime").gte(TimeConvertor.stringTime2Date("2020-01-18 15:24:08", TimeConvertor.FORMAT_MINUS_24HOUR));
		//query.addCriteria(Criteria.where("bmsInfo.bMSCode").is("bmsCode001").andOperator(bmsVer,inTime));
		//ChargingProcessInfoHot findChargingProcessInfoHot = mongoTemplate.findOne(query, ChargingProcessInfoHot.class, "charging_process_info_hot");
		//System.out.println("查询单个结果"+findChargingProcessInfoHot);
		//{ "bmsInfo.bMSCode" : "bmsCode001" , "$and" : [ { "bmsInfo.bMSVer" : "bmsVer002"} , { "bmsInfo.inTime" : { "$date" : "2020-01-18T07:24:08.000Z"}}]}
		//查询多个方法
		//List<ChargingProcessInfoHot> findList = mongoTemplate.find(new Query(Criteria.where("bmsInfo.inTime").gte("xxx").lte("yyy")), ChargingProcessInfoHot.class, "charging_process_info_hot");
		List<ChargingProcessInfoHot> findList = mongoTemplate.find(new Query(Criteria.where("bmsInfo.bMSCode").is("bmsCode001")), ChargingProcessInfoHot.class, "charging_process_info_hot");
		for (ChargingProcessInfoHot chargingProcessInfoHot2 : findList) {
			System.out.println(chargingProcessInfoHot2);
		}
		return "OK";
	}
}
