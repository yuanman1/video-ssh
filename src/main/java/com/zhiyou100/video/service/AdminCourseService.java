package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.service.base.BaseService;

public interface AdminCourseService extends BaseService<Course>{

	List<Course> findallCourse();

	List<Course> findCourseList(Course model);

}
