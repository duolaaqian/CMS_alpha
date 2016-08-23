package com.dlaq.oa.basic.user;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.webframe.core.BaseDao;

import com.dlaq.oa.basic.core.BaseService;
import com.dlaq.oa.basic.model.TUser;

@Service
public class UserService extends BaseService implements UserDetailsService{

	@Autowired
	BaseDao baseDao;
	
	public boolean saveUser(TUser u){
		if(isExistUsername(u.getUsername())){
			return false;
		}
		u.setPassword("111111");
		baseDao.save(u);
		return true;
	}
	
	private boolean isExistUsername(String username){
		String hql = "from TUser where username = '"+username+"'";
		List<?> find = baseDao.find(hql);
		return find.size()>0?true:false;
	}
	
	
	
	
	
	/**
	 * spring security 登陆验证方法
	 */
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException, DataAccessException {
		TUser u = findUserByCode(arg0);
		return u;
	}
	
	public TUser findUserByCode(String code){
		if(StringUtils.isBlank(code)){return null;}
		String hql = "from TUser u where u.username='"+code+"'";
		@SuppressWarnings("unchecked")
		List<TUser> userList = (List<TUser>) getBaseDao().find(hql);
		if(userList.isEmpty()){
			return null;
		}else{
			return userList.get(0);
		}
	}
	
}
