package com.zhiyou100.video.service;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.base.BaseService;
import com.zhiyou100.video.utils.Page;

public interface AdminSpeakerService extends BaseService<Speaker>{

	Page<Speaker> findpageTRoleSpeaker(int page, String speaker_name, String speaker_job);

}
