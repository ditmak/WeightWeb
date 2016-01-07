package com.csl.web.weight.bean;

import java.util.Date;

import com.csl.mybatis.annotation.MyBatisColumn;

public class WeightRecord {
    private Date createTime;
    @MyBatisColumn(isID = true)
    private Integer id;
    private Float weight;
    private String comment;
    private Integer userId;

    public Integer getUserId() {
	return this.userId;
    }

    public void setUserId(Integer userId) {
	this.userId = userId;
    }

    public Date getCreateTime() {
	return this.createTime;
    }

    public void setCreateTime(Date createTime) {
	this.createTime = createTime;
    }

    public Integer getId() {
	return this.id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Float getWeight() {
	return this.weight;
    }

    public void setWeight(Float weight) {
	this.weight = weight;
    }

    public String getComment() {
	return this.comment;
    }

    public void setComment(String comment) {
	this.comment = comment;
    }

}
