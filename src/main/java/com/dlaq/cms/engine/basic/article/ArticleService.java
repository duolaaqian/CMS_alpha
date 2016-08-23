package com.dlaq.cms.engine.basic.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webframe.core.BaseDao;
import org.webframe.core.JdbcDao;

import com.dlaq.cms.engine.basic.model.TArticle;


@Service
public class ArticleService {

	@Autowired
	private BaseDao baseDao;
	@Autowired
	private JdbcDao jdbcDao;
	
	public void saveArticle(TArticle article){
		baseDao.save(article);
	}
	
}
