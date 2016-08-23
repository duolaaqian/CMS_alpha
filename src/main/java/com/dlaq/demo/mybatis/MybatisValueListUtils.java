package com.dlaq.demo.mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.webframe.web.page.ValueList;
import org.webframe.web.page.ValueListInfo;
import org.webframe.web.util.WebFrameUtils;

public class MybatisValueListUtils {

	private static final String MYBATIS_VALUELIST_NAMESPACE = "mybatis.valuelist";
	
	private static final String BEAN_NAME_MYBATIS_SESSIONFACTORY = "mybatisSessionFactory";
	
	private static SqlSessionFactory mybatisSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory(){
		if(null==mybatisSessionFactory){
			mybatisSessionFactory = (SqlSessionFactory) WebFrameUtils.getBean(BEAN_NAME_MYBATIS_SESSIONFACTORY);
		}
		return mybatisSessionFactory;
	}
	
	public static ValueList<DynaBean> getValueList(String name,ValueListInfo info){
		
		String statement = MYBATIS_VALUELIST_NAMESPACE+"."+name;
		
		String sql = getSqlSessionFactory().getConfiguration().getMappedStatement(statement).getBoundSql(info.getParams()).getSql();
		System.out.println("[sql]:");
		System.out.println(sql);
		
		SqlSession session = getSqlSessionFactory().openSession();
		List<Map<String, Object>> l = session.selectList(statement,info.getParams());
		List<DynaBean> list = new ArrayList<DynaBean>();
		
		if(l.size()>0){
			DynaProperty[] properties;
			List<DynaProperty> pList = new ArrayList<DynaProperty>();
			Map<String, Object> rootMap = l.get(0);
			for(Entry<String, Object> entry :rootMap.entrySet()){
//				System.out.print("===="+entry.getKey()+"===="+entry.getValue().getClass()+"====");
				if(null!=entry.getValue()){
					pList.add(new DynaProperty(entry.getKey(), entry.getValue().getClass()));	
				}else{
					pList.add(new DynaProperty(entry.getKey(), String.class));
				}
			}
			properties = (DynaProperty[]) pList.toArray(new DynaProperty[list.size()]);
			
			BasicDynaClass bdc = new BasicDynaClass(name, BasicDynaBean.class, properties);
			for(Map<String, Object> m : l){
				try {
					DynaBean dynaBean = bdc.newInstance();
					for(DynaProperty dp : properties){
						dynaBean.set(dp.getName(), m.get(dp.getName()));
					}
					list.add(dynaBean);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		info.setTotalNumbers(10);
		return new ValueList<DynaBean>(list,info);
	}
	
}
