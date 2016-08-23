package org.webframe.web.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.webframe.web.page.ValueList;
import org.webframe.web.page.ValueListInfo;
import org.webframe.web.page.adapter.ValueListAdapter;
import org.webframe.web.page.adapter.ValueListAdapterManager;

public class ValueListUtils {

	private static final String BEAN_NAME_VM = "valueListAdapterManager";
	
	private static final String BEAN_NAME_JDBCTEMPLATE = "jdbcTemplate";
	
	private static ValueListAdapterManager vm;
	
	private static JdbcTemplate jdbcTemplate;
	
	public final static String HYPHEN										= "#";
	
	public static ValueListAdapterManager getValueListAdapterManager(){
		if(null==vm){
			vm = (ValueListAdapterManager) WebFrameUtils.getBean(BEAN_NAME_VM);
		}
		return vm;
	}
	public static JdbcTemplate getJdbcTemplate(){
		if(null==jdbcTemplate){
			jdbcTemplate = (JdbcTemplate) WebFrameUtils.getBean(BEAN_NAME_JDBCTEMPLATE);
		}
		return jdbcTemplate;
	}
	
	
	public static ValueList<DynaBean> getValueList(String name,ValueListInfo info){
		
		ValueListAdapter va = getValueListAdapterManager().getAdapters().get(name);
		String sql = va.getSql();
		
		if(va.isPaging()){
			sql = getPagedSql(sql,info.getPagingNumberPer(),info.getPagingPage());
		}
		if(va.isShowSql()){
			System.out.println("<========["+name+"] sql:======================>");
			System.out.println(sql);
		}
		
		
		List<Map<String, Object>> l = getJdbcTemplate().queryForList(sql);
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
		
		info.setTotalNumbers(getTotalNumber(va.getSql()));
		return new ValueList<DynaBean>(list,info);
	}
	
	private static String getPagedSql(String sql,int pagePreNumber,int pagingPage){
		String tpl = "select * from (\r\n{sql}\r\n) t ";
		tpl += "limit "+( (pagingPage-1)*pagePreNumber )+" , " + pagePreNumber*pagingPage;
		
		sql = tpl.replace("{sql}", sql);
		return sql;
	}
	private static int getTotalNumber(String sql){
		String tpl = "select count(*) COUNT from ({sql}) t";
		sql = tpl.replace("{sql}", sql);
		
		List<Map<String, Object>> queryForList = getJdbcTemplate().queryForList(sql);
		return Integer.parseInt(queryForList.get(0).get("COUNT")+"");
	}
	
	/**
	 * @function
	 * 		将 request 转换成 map<String,Object>
	 * @author luqian  
	 *	Sep 24, 2015 1:44:01 PM
	 */
	public static Map<String, Object> getQueryMap(HttpServletRequest request) {
		return getQueryMap(request, HYPHEN);
	}
	public static Map<String, Object> getQueryMap(HttpServletRequest request, String hyphen) {
		Map<String, Object> attrMap = new HashMap<String, Object>();
		Enumeration<?> keys = request.getParameterNames();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			if (key == null) continue;
			String[] values = request.getParameterValues(key.toString());
			if (values != null && values.length == 1) {
				attrMap.put(key.toString(), values[0]);
			} else if (hyphen == null){
				attrMap.put(key.toString(), values);
			} else {
				attrMap.put(key.toString(), StringUtils.join(values, hyphen));
			}
		}
		return attrMap;
	}
	
	
}
