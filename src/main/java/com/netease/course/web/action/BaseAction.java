package com.netease.course.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.netease.course.utils.TUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * BaseAction封装模型驱动，HttpServletRequest和HttpServletResponse对象
 * 
 * @author
 *
 * @param <T>
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>, ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = 8193803743343469098L;

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected T entity;

	@SuppressWarnings("unchecked")
	public BaseAction() {
		try {
			Class<?> entityClass = TUtils.getTClass(getClass());
			entity = (T) entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public T getModel() {
		return entity;
	}
}
