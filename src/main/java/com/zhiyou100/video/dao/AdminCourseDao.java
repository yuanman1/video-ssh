package com.zhiyou100.video.dao;

import java.util.List;

import com.zhiyou100.video.dao.base.BaseDao;
import com.zhiyou100.video.model.Course;

public interface AdminCourseDao extends BaseDao<Course>{

	List<Course> findallCourse();

	List<Course> findCourseList(Course model);

}
