package com.csl.web.weight.dao;

import org.springframework.stereotype.Repository;

import com.csl.mybatis.DAO.IGenericDao;
import com.csl.web.weight.bean.WeightRecord;

@Repository("weightRecordDAO")
public interface WeightRecordDAO extends IGenericDao<WeightRecord, Integer> {
}
