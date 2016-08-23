package com.dlaq.oa.basic.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dlaq.oa.basic.core.BaseController;
import com.dlaq.oa.basic.core.BaseService;
import com.dlaq.oa.basic.model.TUser;

@Controller
@RequestMapping("/oa-basic/user")
public class UserController extends BaseController{

	private String path = "/oa-basic/user";
	
	@Autowired
	BaseService baseService;
	
	@Autowired
	UserService userService;
	

	@RequestMapping
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("用户管理页面");
		return new ModelAndView(path+"/index");
	}
	
	@RequestMapping("/userList")
	public void userList(HttpServletRequest request, HttpServletResponse response) {
//		String str = "";
		
		String sql = "select * from t_user";
		List<Map<String, Object>> queryForList = baseService.queryForList(sql);
		System.out.println(queryForList);
		JSONObject obj = new JSONObject();
		obj.put("rows", queryForList);
		
//		response.setContentType("text/html; charset=UTF-8");
		outWriteJSON(response, obj.toString());
	}
	
	@RequestMapping("/saveUser")
	public void saveUser(TUser u,HttpServletRequest request, HttpServletResponse response) {
		JSONObject obj = new JSONObject();
		
		System.out.println(u);
		System.out.println(u.getRealName());
		boolean flag = userService.saveUser(u);
		obj.put("flag", flag);
		
		outWriteJSON(response, obj.toString());
	}
}
