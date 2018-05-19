package com.zhiyou100.video.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhiyou100.video.dao.FrontUserDao;
import com.zhiyou100.video.dao.base.impl.BaseDaoImpl;
import com.zhiyou100.video.model.User;
@Repository
public class FrontUserDaoImpl extends BaseDaoImpl<User> implements FrontUserDao{

	@Override
	public User findUserBymodel(User model) {
		List<User> list = (List<User>) getHibernateTemplate().find("from User where email=? and password=?", model.getEmail(),model.getPassword());
		if(list.isEmpty()){
			return null;
		}	
		return list.get(0);
	}

	@Override
	public User findUserJiaoYao(User model) {
		List<User> list = (List<User>) getHibernateTemplate().find("from User where email=?", model.getEmail());
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

}
