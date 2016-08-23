package com.dlaq.oa.basic.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/oa/login")
public class LoginController {
	
	private String path = "/oa-basic";
	
	@RequestMapping
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("后台登陆成功，跳转到后台管理页面！");
		return new ModelAndView(path+"/manage/index");
	}
}
