package com.zhiyou100.video.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.zhiyou100.video.dao.AdminSpeakerDao;
import com.zhiyou100.video.dao.base.impl.BaseDaoImpl;
import com.zhiyou100.video.model.Speaker;
@Repository
public class AdminSpeakerDaoImpl extends BaseDaoImpl<Speaker> implements AdminSpeakerDao{

	@Override
	public int findSpakerCount(DetachedCriteria dc) {
		List<Speaker> list = (List<Speaker>) getHibernateTemplate().findByCriteria(dc);
		return list.size();
	}

	@Override
	public List<Speaker> findSpeakerList(DetachedCriteria dc, int a) {
		List<Speaker> list = (List<Speaker>) getHibernateTemplate().findByCriteria(dc, a, a+5);
		return list;
	}

	

}
