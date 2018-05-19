package com.zhiyou100.video.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.dao.AdminUserDao;
import com.zhiyou100.video.model.admin;
import com.zhiyou100.video.service.AdminUserService;
import com.zhiyou100.video.service.base.impl.BaseServiceImpl;
@Service
public class AdminUserServiceImpl extends BaseServiceImpl<admin> implements AdminUserService {
		
		private AdminUserDao ad;
		@Autowired
		public void setAd(AdminUserDao ad) {
			this.ad = ad;
			super.setDao(ad);
		}
		@Override
		public admin findAdminUser(admin model) {
			admin adm=ad.findAdminUser(model);
			return adm;
		}
		
	
}
