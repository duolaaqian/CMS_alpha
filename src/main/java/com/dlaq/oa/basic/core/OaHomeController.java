package com.dlaq.oa.basic.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OaHomeController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String preLogin() {
		return "/sof_login";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/manage";
	}
	
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manage() {
//		return "/oa-basic/desktop/main";
		return "/oa-basic/manage/index";
	}
}
