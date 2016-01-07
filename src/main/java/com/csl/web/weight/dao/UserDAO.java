package com.csl.web.weight.dao;

import org.springframework.stereotype.Repository;

import com.csl.mybatis.DAO.IGenericDao;
import com.csl.web.weight.bean.User;

@Repository("userDAO")
public interface UserDAO extends IGenericDao<User, Integer> {
}
