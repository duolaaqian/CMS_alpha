package org.webframe.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dlaq.oa.basic.util.UgUserUtils;

public class CommonInterceptor implements HandlerInterceptor{

	private Logger log = Logger.getLogger(CommonInterceptor.class);
	
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		log.info("==============执行顺序: 3、afterCompletion================");
		System.out.println("==============执行顺序: 3、afterCompletion================");
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		log.info("==============执行顺序: 2、postHandle================");
		System.out.println("==============执行顺序: 2、postHandle================");
	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		log.info("==============执行顺序: 1、preHandle================");
		System.out.println("==============执行顺序: 1、preHandle================");
//		return false;
		String path = arg0.getContextPath();
		arg0.setAttribute("ctx", path);
		arg1.setContentType("text/html; charset=UTF-8");//防止乱码

//		arg0.setAttribute("user", UgUserUtils.getCurrentUser());
		
		return true;
	}

}
