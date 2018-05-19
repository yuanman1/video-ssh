package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.dao.AdminVideoDao;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.AdminVideoService;
import com.zhiyou100.video.service.base.impl.BaseServiceImpl;
import com.zhiyou100.video.utils.Page;
@Service
public class AdminVideoServiceImpl extends BaseServiceImpl<Video> implements AdminVideoService{
		
	private AdminVideoDao avd;
	@Autowired
	public void setAvd(AdminVideoDao avd) {
		this.avd = avd;
		super.setDao(avd);
	}
	@Override
	public Page<Video> findpageVideo(int page, String speaker_id, String course_id,String video_title) {
		int count =avd.findpageVideocount(speaker_id,course_id,video_title);
		int page1=(page-1)*5;
		List<Video> list=avd.findpageVideoList(page1,speaker_id,course_id,video_title);
		Page<Video> pa=new Page<>();
		pa.setPage(page);
		pa.setTotal(count);
		pa.setSize(5);
		pa.setRows(list);
		return pa;
	}
	@Override
	public Video findvideoList(Integer videoId) {
		Video video=avd.findvideoList(videoId);
		return video;
	}
	
	
}
