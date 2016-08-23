package com.dlaq.cms.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webframe.core.BaseDao;
import org.webframe.core.JdbcDao;

import com.dlaq.oa.basic.model.TUser;


@Service
public class DemoService {

	@Autowired
	private BaseDao baseDao;
	@Autowired
	private JdbcDao jdbcDao;
	
	public void test(){
		System.out.println("=========DemoService.test()==========");
		
		String id = "402881e5467b8a7e01467b8b94f00003";
		
		TUser u = baseDao.getHibernateTemplate().get(TUser.class, id);
		System.out.println(u.getRealName());
		
		String sql = "select * from t_user where 1=1 ";
//		sql += " and id_ = '"+id+"' ";
		List<Map<String,Object>> list = jdbcDao.queryForList(sql);
		System.out.println(list);
		sql += " and id_ = '"+id+"' ";
		Map<String,Object> map = jdbcDao.queryForMap(sql);
		System.out.println(map);
		
	}
	
}
