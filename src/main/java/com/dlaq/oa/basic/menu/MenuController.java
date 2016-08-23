package com.dlaq.oa.basic.menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	private String path = "/oa-basic/menu";
	

	@RequestMapping
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("菜单管理页面");
		return new ModelAndView(path+"/index");
	}
	
}
