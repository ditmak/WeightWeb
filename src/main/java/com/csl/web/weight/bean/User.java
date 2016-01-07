package com.csl.web.weight.bean;

import java.util.Date;

public class User {
    private Integer id;
    private String nickName;
    private String loginName;
    private String password;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
	return this.id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNickName() {
	return this.nickName;
    }

    public void setNickName(String nickName) {
	this.nickName = nickName;
    }

    public String getLoginName() {
	return this.loginName;
    }

    public void setLoginName(String loginName) {
	this.loginName = loginName;
    }

    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Date getCreateTime() {
	return this.createTime;
    }

    public void setCreateTime(Date createTime) {
	this.createTime = createTime;
    }

    public Date getUpdateTime() {
	return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
	this.updateTime = updateTime;
    }

}
