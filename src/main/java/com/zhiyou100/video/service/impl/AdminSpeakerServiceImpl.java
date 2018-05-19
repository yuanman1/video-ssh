package com.zhiyou100.video.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.dao.AdminCourseDao;
import com.zhiyou100.video.dao.AdminSpeakerDao;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.AdminSpeakerService;
import com.zhiyou100.video.service.base.impl.BaseServiceImpl;
import com.zhiyou100.video.utils.Page;
@Service
public class AdminSpeakerServiceImpl extends BaseServiceImpl<Speaker> implements AdminSpeakerService{
	private AdminSpeakerDao asd;
	@Autowired
	public void setAsd(AdminSpeakerDao asd) {
		this.asd = asd;
		super.setDao(asd);
	}
	@Override
	public Page<Speaker> findpageTRoleSpeaker(int page, String speaker_name, String speaker_job) {

		DetachedCriteria dc=DetachedCriteria.forClass(Speaker.class);
		dc.add(Restrictions.like("speaker_name", "%"+speaker_name+"%")).add(Restrictions.like("speaker_job", "%"+speaker_job+"%"));
		int count=asd.findSpakerCount(dc);
		int a=(page-1)*5;
		List<Speaker> list= asd.findSpeakerList(dc,a);
		Page<Speaker> pa=new Page<>();
		pa.setPage(page);
		pa.setTotal(count);
		pa.setSize(5);
		pa.setRows(list);
		return pa;
	}

}
