package com.dlaq.oa.basic.core;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webframe.core.BaseDao;
import org.webframe.core.JdbcDao;

@Service
public class BaseService {
	@Autowired
	private BaseDao baseDao;
	@Autowired
	private JdbcDao jdbcDao;
	
	public BaseDao getBaseDao(){
		return this.baseDao;
	}
	public JdbcDao getJdbcDao(){
		return this.jdbcDao;
	}
	
	public List<Map<String,Object>> queryForList(String sql){
		return jdbcDao.queryForList(sql);
	}
	
}
