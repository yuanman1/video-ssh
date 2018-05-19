package com.zhiyou100.video.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.dao.FrontUserDao;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.FrontUserService;
import com.zhiyou100.video.service.base.impl.BaseServiceImpl;
@Service
public class FrontUserServiceImpl extends BaseServiceImpl<User> implements FrontUserService{
	
	private FrontUserDao fud;
	@Autowired
	public void setFud(FrontUserDao fud) {
		this.fud = fud;
		super.setDao(fud);
	}
	@Override
	public User findUserBymodel(User model) {
		return fud.findUserBymodel(model);
	}
	@Override
	public User findUserJiaoYao(User model) {
		return fud.findUserJiaoYao(model);
	}
	
}
