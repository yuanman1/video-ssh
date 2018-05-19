package com.zhiyou100.video.web.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;

import com.opensymphony.xwork2.ActionContext;
import com.zhiyou100.video.model.Success;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.FrontUserService;
import com.zhiyou100.video.utils.MailUtil;
import com.zhiyou100.video.web.action.base.BaseAction;
@Controller
@Scope(scopeName="prototype")
public class FrontUserAction extends BaseAction<User>{
	@Autowired
	private FrontUserService fus;
	private Success succ;
	private String email1;
	private File image_file;
	private String image_fileFileName;
	private String oldPassword;
	private String newPassword;
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public File getImage_file() {
		return image_file;
	}
	public void setImage_file(File image_file) {
		this.image_file = image_file;
	}
	public String getImage_fileFileName() {
		return image_fileFileName;
	}
	public void setImage_fileFileName(String image_fileFileName) {
		this.image_fileFileName = image_fileFileName;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public Success getSucc() {
		return succ;
	}
	public void setSucc(Success succ) {
		this.succ = succ;
	}
	public String login(){
		return SUCCESS;		
	}
	public String logout(){
		ActionContext.getContext().getSession().remove("_front_user");
		return SUCCESS;		
	}
	public String tuichu(){
		return SUCCESS;		
	}
	public String login1(){
		model.setPassword(DigestUtils.md5DigestAsHex(model.getPassword().getBytes()));
		User user=fus.findUserBymodel(model);
		succ=new Success();
		if(user==null){
			succ.setSuccess(false);
			succ.setMessage("邮箱密码不匹配！！");
			return SUCCESS;
		}
		ActionContext.getContext().getSession().put("_front_user", user);
		succ.setSuccess(true);
		return SUCCESS;		
	}
	public String regist(){
		User user=fus.findUserJiaoYao(model);
		succ=new Success();
		if(user != null){
			succ.setSuccess(false);
			succ.setMessage("email已存在，注册失败！！！");	
			return SUCCESS;
		}
		model.setPassword(DigestUtils.md5DigestAsHex(model.getPassword().getBytes()));
		Date date=new Date();
		model.setInsertTime(date);
		fus.addEntity(model);
		succ.setSuccess(true);
		return SUCCESS;		
	}
	public String userIndex(){
		User user = (User) ActionContext.getContext().getSession().get("_front_user");
		User user2 = fus.findUserJiaoYao(user);
		 ActionContext.getContext().getSession().put("user", user2);
		return SUCCESS;		
	}
	//跳到更改资料页面
	public String userprofile(){
		return "profile";		
	}
	//更改资料
	public String userprofile1(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		model.setEmail(user.getEmail());
		model.setInsertTime(user.getInsertTime());
		model.setPassword(user.getPassword());
		model.setHeadUrl(user.getHeadUrl());
		model.setCaptcha(user.getCaptcha());
		Date date=new Date();
		model.setUpdateTime(date);
		fus.updateEntity(model);
		return "allindex";		
	}
	//更改头像
	public String useravatar(){
		return "avatar";
	}
	public String useravatar1() throws IOException{
		String extension = FilenameUtils.getExtension(image_fileFileName);
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		FileUtils.copyFile(image_file, new File("e:/head_url/"+name+"."+extension));
		User user = (User) ActionContext.getContext().getSession().get("user");
		user.setHeadUrl(name+"."+extension);
		Date date=new Date();
		user.setUpdateTime(date);
		fus.updateEntity(user);
		return "allindex";
	}
	//更改密码
	public String userpassword(){
		return "password";	
	}
	public String userpassword1(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		model.setEmail(user.getEmail());
		model.setPassword(DigestUtils.md5DigestAsHex(oldPassword.getBytes()));
		User user2 = fus.findUserBymodel(model);
		if(user2==null){
			ActionContext.getContext().put("error_pwd", "密码错误！！");
			return "password";
		} 
		user2.setPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
		fus.updateEntity(user2);
		return "allindex";	
	}
	
	//忘记密码---------------------------------------------------------------------
	public String userforget_pwd(){
		return "forget_pwd";
	}
	public String sendemail() throws Exception{
		succ=new Success();
		int a=(int)(Math.random()*1000000);
		User user = fus.findUserJiaoYao(model);
		if(user==null){
			succ.setSuccess(false);
			succ.setMessage("邮件名不存在！！");
			return SUCCESS;
		}
		user.setCaptcha(a+"");
		fus.updateEntity(user);
		MailUtil.send(model.getEmail(),"智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！", "您好，智游教育在线公开课此次重置密码的验证码为："+a+",如果不是本人操作，请忽略本消息。");
		succ.setSuccess(true);
		return SUCCESS;
	}
	public String userreset_pwd(){
		System.out.println(model);
		User user = fus.findUserJiaoYao(model);
		if(user.getCaptcha().equals(model.getCaptcha())){
			ActionContext.getContext().put("email", model.getEmail());
			return "reset_pwd";
		}
		ActionContext.getContext().put("error_forget", "验证码不正确！！");
		return "forget_pwd";
	}
	public String userreset_pwd1(){
	System.out.println(model);
	User user = fus.findUserJiaoYao(model);
	user.setPassword(DigestUtils.md5DigestAsHex(model.getPassword().getBytes()));
	System.out.println(user);
	fus.updateEntity(user);
		return "forget_pwd";
	}
	
	
	
	
	
	
	
}
