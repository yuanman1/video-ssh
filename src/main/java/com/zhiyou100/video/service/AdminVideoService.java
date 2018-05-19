package com.zhiyou100.video.service;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.base.BaseService;
import com.zhiyou100.video.utils.Page;

public interface AdminVideoService extends BaseService<Video>{

	Page<Video> findpageVideo(int page, String speaker_name, String course_name, String video_title);

	Video findvideoList(Integer videoId);


}
