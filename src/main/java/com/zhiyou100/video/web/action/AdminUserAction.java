package com.zhiyou100.video.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhiyou100.video.model.admin;
import com.zhiyou100.video.service.AdminUserService;
import com.zhiyou100.video.web.action.base.BaseAction;
@Controller
@Scope(scopeName="prototype")
public class AdminUserAction extends BaseAction<admin>{
	@Autowired
	private AdminUserService as;
	
		public String login(){
			return SUCCESS;
		}
		public String login1(){
			model.setLogin_pwd(DigestUtils.md5DigestAsHex(model.getLogin_pwd().getBytes()));
			admin ad=as.findAdminUser(model);
			if(ad==null){
				ActionContext.getContext().put("errorMessage", "用户名密码不匹配！！");
				return SUCCESS;
			}
			  ActionContext.getContext().getSession().put("Login_user", ad);
			return "header";
		}
		
		
		public String logout(){
			ActionContext.getContext().getSession().remove("Login_user");
			return SUCCESS;
		}
		
}
