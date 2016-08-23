package org.webframe.core;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * 类功能描述：hibernate 相关dao
 * 
 * @author luqian  下午9:48:01
 */
@Repository
public class BaseDao {

//	@Resource
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public void save(Object entity){
		hibernateTemplate.save(entity);
	}
	
	public List<?> find(String hql){
		return hibernateTemplate.find(hql);
	}
	
	public void delete(Object entity){
		hibernateTemplate.delete(entity);
	}
	
	public void saveOrUpdate(Object entity){
		hibernateTemplate.saveOrUpdate(entity);
	}
	
	public void update(Object entity){
		hibernateTemplate.update(entity);
	}
	
	public void get(Class<Object> entityClass, Serializable id){
		hibernateTemplate.get(entityClass, id);
	}
	
	public List<?> findBySql(String sql){
		return this.findBySql(sql);
	}
}
