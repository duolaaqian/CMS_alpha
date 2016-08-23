package com.dlaq.demo.mybatis;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.DynaBean;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.webframe.web.page.ValueList;
import org.webframe.web.page.ValueListInfo;
import org.webframe.web.util.ValueListUtils;

import com.dlaq.oa.basic.core.BaseController;

@Controller
@RequestMapping("/mybatis")
public class MyBatisDemoController extends BaseController{
	
	@Autowired
	SqlSessionFactory mybatisSessionFactory;

	@RequestMapping("/test")
	public void test(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("=mybatis=test==");
		System.out.println(mybatisSessionFactory);
		
		SqlSession session = mybatisSessionFactory.openSession();
		String statement = "";//映射sql的标识字符串
		
		statement = "mybatis.userMapper.getAllUser";
		List<User> l = session.selectList(statement);
		System.out.println(l.size());
		
//		statement = "mybatis.userMapper.getUser";
//		User u = session.selectOne(statement, "402881d64ffdd65a014ffddc23320005");
//		System.out.println(u.getREALNAME_());
	}
	
	@RequestMapping("/test2")
	public void test2(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("=mybatis=test2==");

//		Collection<String> keyGeneratorNames = mybatisSessionFactory.getConfiguration().getKeyGeneratorNames();
		SqlSession session = mybatisSessionFactory.openSession();
		Collection<MappedStatement> mappedStatements = session.getConfiguration().getMappedStatements();
		System.out.println("***************************");
		for(MappedStatement ms : mappedStatements){
			System.out.println(ms.getId());
		}
	}
	@RequestMapping("/test3")
	public void test3(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("=mybatis=test3==");

//		System.out.println("[username]  -->  "+request.getParameter("username"));
//		System.out.println(request.getCharacterEncoding());

		
		Map<String,Object> m = ValueListUtils.getQueryMap(request);
		ValueListInfo info = new ValueListInfo(m);
		info.setPagingNumberPer(20);
		info.setPagingPage(1);
		
		ValueList<DynaBean> valueList = MybatisValueListUtils.getValueList("getUser_r", info);
		JSONObject obj = new JSONObject();
		obj.put("result", valueList.getList());
		
		outWriteJSON(response, obj.toString());
	}
	
}
