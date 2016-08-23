package org.webframe.core;

import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.webframe.support.util.SystemLogUtils;
import org.webframe.web.page.adapter.ValueListAdapter;
import org.webframe.web.page.adapter.ValueListAdapterManager;
import org.webframe.web.util.WebFrameUtils;

public class ValueListInit implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		SystemLogUtils.rootPrintln("初始化valuelist开始！");
		initValueList();
		SystemLogUtils.rootPrintln("初始化valuelist结束！");
	}
	
	private static void initValueList(){
		ValueListAdapterManager vManage = (ValueListAdapterManager) WebFrameUtils.getBean("valueListAdapterManager");
		Map<String ,ValueListAdapter> adapters = vManage.getAdapters();
		
		ApplicationContext ctx = WebFrameUtils.getApplicationContext();
		Map<String,ValueListAdapterManager> map = ctx.getBeansOfType(ValueListAdapterManager.class);
		
		for(String k : map.keySet()){
			ValueListAdapterManager vm = map.get(k);
			Object appended = vm.getAppended();
			if( null!=appended && appended instanceof Map ){
				@SuppressWarnings("unchecked")
				Map<String,ValueListAdapter> m = (Map<String,ValueListAdapter>) appended;
				for(String kk : m.keySet()){
					if(adapters.containsKey(kk)){
						System.out.println("====> key值重复["+kk+"]！");
					}else{
						adapters.put(kk, m.get(kk));
						System.out.println("====> 添加key["+kk+"]");
					}
				}
			}
		}
	}
	
	public static void reloadValuelist(){
		ValueListAdapterManager vManage = (ValueListAdapterManager) WebFrameUtils.getBean("valueListAdapterManager");
		Map<String ,ValueListAdapter> adapters = vManage.getAdapters();
		adapters.clear();
		initValueList();
	}

}
