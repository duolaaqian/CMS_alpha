package org.webframe.web.page.adapter;

import java.util.LinkedHashMap;
import java.util.Map;


public class ValueListAdapterManager{
	
	
	private int order=0;
	
	private Object	appended;
	
	private static final Map<String, ValueListAdapter> adapters = new LinkedHashMap<String, ValueListAdapter>(16);

	public Map<String, ValueListAdapter> getAdapters(){
		return adapters;
	}
	
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Object getAppended() {
		return appended;
	}

	public void setAppended(Object appended) {
		this.appended = appended;
	}



}
