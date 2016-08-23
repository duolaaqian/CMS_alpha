package com.dlaq.cms.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.beanutils.DynaBean;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.webframe.web.page.ValueList;
import org.webframe.web.page.adapter.ValueListAdapter;
import org.webframe.web.page.adapter.ValueListAdapterManager;
import org.webframe.web.util.ValueListUtils;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	private String path = "/demo";
	private Logger log = Logger.getLogger(DemoController.class);
	
	@Autowired
	DemoService demoService;
	
	@RequestMapping
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("后台登陆成功");
		log.info("后台登陆成功==");
		System.out.println("===");
/*		Map<String,Object> m = request.getParameterMap();
		String s[] = (String[]) m.get("a");
		System.out.println(m);
		System.out.println(s);*/
		System.out.println("===");
//		demoService.test();
//		TUser u = new TUser();
		
//		JSONObject obj = new JSONObject();
		
		
		
//		return new ModelAndView("/combox/combox_test1");
		return new ModelAndView(path+"/index");
	}
	
	@RequestMapping("/test")
	public void test(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("=sys=test==");
		log.info("=log=test==");
		System.out.println("===");

		ServletContext sc = request.getSession().getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
		System.out.println(ctx);
//		demoService.test();
//		DemoService ds = ctx.getBean(DemoService.class);
//		System.out.println(ds);
		
//		return new ModelAndView(path+"/index");
	}
	
	@RequestMapping("/vlTest")
	public void vlTest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("=vlTest==");
		log.info("=vlTest==");
		System.out.println("===");
		
		ServletContext sc = request.getSession().getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
/*		System.out.println(ctx.containsBean("valueListAdapterManager"));
		ValueListAdapterManager vm = (ValueListAdapterManager) ctx.getBean("valueListAdapterManager");
		System.out.println(vm.getOrder());*/
		
		Map<String ,ValueListAdapter> adapters = new HashMap<String ,ValueListAdapter>();
		
		Map<String,ValueListAdapterManager> o = ctx.getBeansOfType(ValueListAdapterManager.class);
//		System.out.println(o);
		for(String k : o.keySet()){
//			System.out.println(o.get(k));
			ValueListAdapterManager vm = o.get(k);
//			System.out.println(vm.getOrder());
			
			Object appended = vm.getAppended();
//			if(null!=appended){
//				System.out.println("====>"+appended.getClass());
//			}
			
			
			if( null!=appended && appended instanceof Map ){
//				ValueListAdapter adp = (ValueListAdapter)appended;
				Map<String,ValueListAdapter> m = (Map<String,ValueListAdapter>) appended;
				for(String kk : m.keySet()){
					if(adapters.containsKey(kk)){
						System.err.println("====> key值重复["+kk+"]！");
					}else{
						adapters.put(kk, m.get(kk));
						System.out.println("====> 添加key["+kk+"]");
					}
				}
			}
		}
		
		
		System.out.println(adapters);
		System.out.println(adapters.get("aaaaAdapter"));
		
		
	}
	@RequestMapping("/vlTest2")
	public void vlTest2(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("=vlTest2==");

		ValueList<DynaBean> valueList = ValueListUtils.getValueList("allUserAdapter", null);
		List<DynaBean> list = valueList.getList();
		System.out.println("查询结果大小："+list.size());
		
		System.out.println(JSONArray.fromObject(list));
		
	}
}
