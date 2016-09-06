package com.netease.course.web.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.netease.course.web.form.MenuForm;

@Controller(value = "elecMenuAction")
@Scope(value = "prototype")
public class ElecMenuAction extends BaseAction<MenuForm> {

	private static final long serialVersionUID = 1L;

	private MenuForm menuForm = getModel();

	/**
	 * 保存
	 * 
	 * @return
	 */
	public String menuHome() {
		System.out.println(menuForm);
		return "menuHome";
	}

	/** 标题 */
	public String title() {
		return "title";
	}

	/** 菜单 */
	public String left() {
		return "left";
	}

	/** 框架大小改变 */
	public String change() {
		return "change";
	}

	/**
	 * @Name: loading
	 */
	public String loading() {

		return "loading";
	}

	/** 框架大小改变 */
	public String logout() {
		request.getSession().invalidate();
		return "logout";
	}

}
