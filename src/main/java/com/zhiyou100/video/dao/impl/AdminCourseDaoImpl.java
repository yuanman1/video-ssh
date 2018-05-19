package com.zhiyou100.video.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhiyou100.video.dao.AdminCourseDao;
import com.zhiyou100.video.dao.base.impl.BaseDaoImpl;
import com.zhiyou100.video.model.Course;
@Repository
public class AdminCourseDaoImpl extends BaseDaoImpl<Course> implements AdminCourseDao{

	@Override
	public List<Course> findallCourse() {
		List<Course> list = (List<Course>) getHibernateTemplate().find("from Course");
		return list;
	
	
		
	}

	@Override
	public List<Course> findCourseList(Course model) {
		List<Course> list = (List<Course>) getHibernateTemplate().find("from Course where subject_id=?", model.getSubject_id());
		return list;
	}

}
