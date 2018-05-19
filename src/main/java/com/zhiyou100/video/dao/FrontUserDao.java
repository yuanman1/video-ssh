package com.zhiyou100.video.dao;

import com.zhiyou100.video.dao.base.BaseDao;
import com.zhiyou100.video.model.User;

public interface FrontUserDao extends BaseDao<User>{

	User findUserBymodel(User model);

	User findUserJiaoYao(User model);

}
