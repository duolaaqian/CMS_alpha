package com.dlaq.oa.basic.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.dlaq.oa.basic.model.TUser;


public class UgUserUtils {

	public static TUser getCurrentUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object o = auth.getPrincipal();
		if( null!=o && o instanceof TUser){
			return (TUser)o;
		}else{
			return null;
		}
	}
	
}
