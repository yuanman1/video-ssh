package com.zhiyou100.video.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhiyou100.video.dao.AdminUserDao;
import com.zhiyou100.video.dao.base.impl.BaseDaoImpl;
import com.zhiyou100.video.model.admin;
@Repository
public class AdminUserDaoImpl extends BaseDaoImpl<admin> implements AdminUserDao{

	@Override
	public admin findAdminUser(admin model) {
		List<admin> list = (List<admin>) getHibernateTemplate()
				.find("from admin where login_name=? and login_pwd=?", model.getLogin_name(),model.getLogin_pwd());
		if(list.isEmpty()){
			return null;
		}
			return list.get(0);
		}
}
