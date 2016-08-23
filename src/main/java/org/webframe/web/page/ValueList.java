package org.webframe.web.page;

import java.util.List;

public class ValueList<T> {
	
	private List<T>				list					= null;

	private ValueListInfo		info					= null;
	
	public List<T> getList(){
		return list;
	}

	public ValueListInfo getValueListInfo() {
		return info;
	}
	
	public ValueList(List<T> list, ValueListInfo info) {
		this.list = list;
		this.info = info;
	}

	
}
