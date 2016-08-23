package com.dlaq.cms.engine.basic.article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dlaq.cms.engine.basic.model.TArticle;
import com.dlaq.oa.basic.core.BaseController;

@Controller
@RequestMapping("/cms-basic/article")
public class ArticleController extends BaseController{
	
	private String path = "/cms-basic/article";
	private Logger log = Logger.getLogger(ArticleController.class);
	
	@Autowired
	ArticleService articleService;
	
	@RequestMapping
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		log.info("");
		System.out.println("==文章管理后台登陆成功==");
		
//		ValueListInit.reloadValuelist();
		return new ModelAndView(path+"/index");
	}
	
	@RequestMapping("/addArticle")
	public void addArticle(TArticle article, HttpServletRequest request, HttpServletResponse response) {
		articleService.saveArticle(article);
		JSONObject obj = new JSONObject();
		
		outWriteJSON(response, obj.toString());
	}
	
	
}
