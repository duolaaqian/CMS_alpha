package org.webframe.web.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WebFrameUtils implements ApplicationContextAware{
	
	private static ApplicationContext	ac	= null;	
	
//	public static void init(ApplicationContext context) {
//		if (context == null) return;
//		ac = context;
//	}

	public static Object getBean(String beanName) {
		return ac.getBean(beanName);
	}
	
	public static ApplicationContext getApplicationContext(){
		return ac;
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("==set ac==");
		WebFrameUtils.ac = applicationContext;
	}
	
}
