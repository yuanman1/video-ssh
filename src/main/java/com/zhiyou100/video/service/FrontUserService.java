package com.zhiyou100.video.service;

import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.base.BaseService;

public interface FrontUserService extends BaseService<User>{

	User findUserBymodel(User model);

	User findUserJiaoYao(User model);

}
