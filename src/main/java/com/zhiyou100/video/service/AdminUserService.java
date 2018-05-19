package com.zhiyou100.video.service;

import com.zhiyou100.video.model.admin;
import com.zhiyou100.video.service.base.BaseService;

public interface AdminUserService extends BaseService<admin>{

	admin findAdminUser(admin model);

}
