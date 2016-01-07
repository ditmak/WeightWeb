package com.csl.web.weight.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csl.mybatis.utils.Conditions;
import com.csl.web.weight.bean.WeightRecord;
import com.csl.web.weight.dao.WeightRecordDAO;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;

@RequestMapping("/")
@Controller
public class IndexController {
    @Resource(name = "weightRecordDAO")
    private WeightRecordDAO wrDAO;

    @RequestMapping("index.html")
    public void index() {

    }

    @RequestMapping("recordWeight")
    public @ResponseBody String recordWeight(@RequestParam String comment,
	    @RequestParam float weight) {
	WeightRecord record = new WeightRecord();
	record.setCreateTime(new Date());
	record.setComment(comment);
	record.setWeight(weight);
	this.wrDAO.insertEntity(record);
	return "success";
    }

    @RequestMapping("getLastRecords")
    /*
     * 参数使用Integer， 原生类型会报错
     */
    public String getRecords(Integer size) {
	PageHelper.startPage(0, 7, false);
	List<WeightRecord> findEntity = this.wrDAO.findEntity(new Conditions()
		.orderBy("createTime", true));
	Gson gson = new Gson();
	return gson.toJson(findEntity);
    }
}
