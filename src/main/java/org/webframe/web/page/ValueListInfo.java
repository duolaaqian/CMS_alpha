package org.webframe.web.page;

import java.util.HashMap;
import java.util.Map;

public class ValueListInfo {
	
	/**
	 * 查询参数
	 */
	private Map<String,Object> params;
	
	public ValueListInfo(){
		setParams(new HashMap<String,Object>());
	}
	public ValueListInfo(Map<String,Object> map){
		setParams(map);
	}
	
	/**
	 * 每页显示条数
	 */
	private int pagingNumberPer=10;
	
	/**
	 * 显示第几页
	 */
	private int pagingPage=1;
	
	/**
	 * 返回结果总条数
	 */
	private int totalNumbers=0;

	public int getPagingNumberPer() {
		return pagingNumberPer;
	}

	public void setPagingNumberPer(int pagingNumberPer) {
		this.pagingNumberPer = pagingNumberPer;
	}

	public int getPagingPage() {
		return pagingPage;
	}

	public void setPagingPage(int pagingPage) {
		this.pagingPage = pagingPage;
	}

	public int getTotalNumbers() {
		return totalNumbers;
	}

	public void setTotalNumbers(int totalNumbers) {
		this.totalNumbers = totalNumbers;
	}
	public Map<String,Object> getParams() {
		return params;
	}
	public void setParams(Map<String,Object> params) {
		this.params = params;
	}
	
	

}
