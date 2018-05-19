package com.zhiyou100.video.dao;

import com.zhiyou100.video.dao.base.BaseDao;
import com.zhiyou100.video.model.admin;

public interface AdminUserDao extends BaseDao<admin>{

	admin findAdminUser(admin model);

}
