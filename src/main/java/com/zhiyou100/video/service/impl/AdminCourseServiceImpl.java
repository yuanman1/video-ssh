package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.dao.AdminCourseDao;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.service.AdminCourseService;
import com.zhiyou100.video.service.base.impl.BaseServiceImpl;
@Service
public class AdminCourseServiceImpl extends BaseServiceImpl<Course> implements AdminCourseService{
		private AdminCourseDao acd;
		@Autowired
		public void setAcd(AdminCourseDao acd) {
			this.acd = acd;
			super.setDao(acd);
		}
		@Override
		public List<Course> findallCourse() {
			// TODO Auto-generated method stub
			return acd.findallCourse();
		}
		@Override
		public List<Course> findCourseList(Course model) {
			List<Course> list=acd.findCourseList(model);
			return list;
		}
		
}
