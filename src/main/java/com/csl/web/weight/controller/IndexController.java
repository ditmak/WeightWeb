package com.csl.web.weight.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csl.web.weight.bean.WeightRecord;
import com.csl.web.weight.dao.WeightRecordDAO;

@RequestMapping("/")
@Controller
public class IndexController {
	@Resource(name ="weightRecordDAO")
	private WeightRecordDAO wrDAO ;

	@RequestMapping("index.html")
	public void index() {

	}
	@RequestMapping("recordWeight")
	public @ResponseBody String recordWeight(@RequestParam String comment,@RequestParam float weight){
		WeightRecord record = new WeightRecord();
		record.setCreateTime(new Date());
		record.setComment(comment);
		record.setWeight(weight);
		wrDAO.insertEntity(record);
		return "success";
	}
}
