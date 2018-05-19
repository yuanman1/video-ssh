package com.zhiyou100.video.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.video.dao.base.BaseDao;
import com.zhiyou100.video.model.Speaker;

public interface AdminSpeakerDao extends BaseDao<Speaker>{

	int findSpakerCount(DetachedCriteria dc);

	List<Speaker> findSpeakerList(DetachedCriteria dc, int a);

	

}
