package com.zhiyou100.video.web.action;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.AdminCourseService;
import com.zhiyou100.video.service.AdminSubjectService;
import com.zhiyou100.video.web.action.base.BaseAction;
@Controller
@Scope(scopeName="prototype")
public class FrontCourseAction extends BaseAction<Course>{
	@Autowired
	private AdminCourseService acs;
	
	public String frontCourse(){
		List<Course> course=acs.findCourseList(model);
		ActionContext.getContext().put("courses", course);
		for (Course course2 : course) {
			ActionContext.getContext().put("subject", course2.getSubject());
			course2.setVi(course2.getVideos());
		}
		return SUCCESS;
		
	}
}
