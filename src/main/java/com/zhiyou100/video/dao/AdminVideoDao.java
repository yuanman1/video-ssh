package com.zhiyou100.video.dao;

import java.util.List;

import com.zhiyou100.video.dao.base.BaseDao;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Video;

public interface AdminVideoDao extends BaseDao<Video>{

	int findpageVideocount(String speaker_id, String course_id, String video_title);

	List<Video> findpageVideoList(int page1, String speaker_id, String course_id, String video_title);

	Video findvideoList(Integer videoId);


}
