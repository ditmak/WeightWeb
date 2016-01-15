package com.csl.web.weight.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csl.mybatis.utils.Conditions;
import com.csl.web.weight.bean.UIResultBean;
import com.csl.web.weight.bean.WeightRecord;
import com.csl.web.weight.dao.WeightRecordDAO;
import com.csl.web.weight.filter.SystemContext;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("")
public class IndexController {
	;

	private static Logger log = LoggerFactory.getLogger(IndexController.class);
	@Resource(name = "weightRecordDAO")
	private WeightRecordDAO wrDAO;

	@RequestMapping("index.chtml")
	public void index() {

	}

	@RequestMapping("recordWeight.chtml")
	public @ResponseBody String recordWeight(@RequestParam String comment,
			@RequestParam float weight) {
		WeightRecord record = new WeightRecord();
		record.setCreateTime(new Date());
		record.setComment(comment);
		record.setWeight(weight);
		wrDAO.insertEntity(record);
		return "success";
	}

	@RequestMapping("/getLastRecords.chtml")
	/*
	 * 参数使用Integer， 原生类型会报错
	 */
	public @ResponseBody void getRecords(Integer size,String userID) throws IOException {
		PageHelper.startPage(1, 7);
		List<WeightRecord> findEntity = wrDAO.findEntity(new Conditions()
		.orderBy("createTime", true));
		SystemContext.outputJson(UIResultBean.getDataResult(findEntity));
	}
}
