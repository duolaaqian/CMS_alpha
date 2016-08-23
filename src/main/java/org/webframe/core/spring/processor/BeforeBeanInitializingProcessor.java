package org.webframe.core.spring.processor;

import java.util.Map;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeforeBeanInitializingProcessor implements BeanPostProcessor{
	
	private String	beanName;
	
	private String	propertyName;
	
	private Object	appended;
	
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("==1==Before==["+beanName+"]==["+bean.getClass()+"]==["+bean.toString()+"]");
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
//		System.out.println("==2==After==["+bean.getClass()+"]==["+bean.toString()+"]");
		
		if (beanName.equals(getBeanName())) {
			beforeInitialization(bean);
		}
		
		return bean;
	}
	
	protected void beforeInitialization(Object bean) {
		BeanWrapperImpl beanWrapper = new BeanWrapperImpl(bean);
		Class<?> propertyType = beanWrapper.getPropertyType(getPropertyName());
		if(Map.class.isAssignableFrom(propertyType)){
			disposeMapProperty(beanWrapper);	
		}
		
	}
	
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public Object getAppended() {
		return appended;
	}

	public void setAppended(Object appended) {
		this.appended = appended;
	}
	
	protected void disposeMapProperty(BeanWrapperImpl beanWrapper) {
		
	}
}
