package com.zhiyou100.video.web.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.AdminCourseService;
import com.zhiyou100.video.service.AdminSubjectService;
import com.zhiyou100.video.web.action.base.BaseAction;
@Controller
@Scope(scopeName="prototype")
public class AdminCourseAction extends BaseAction<Course>{
		@Autowired
		private AdminCourseService acs;
		@Autowired
		private AdminSubjectService ass;
		
		private Integer id1;
		
		public Integer getId1() {
			return id1;
		}
		public void setId1(Integer id1) {
			this.id1 = id1;
		}
		public String courseList(){
			List<Course> list=acs.findallCourse();
			ActionContext.getContext().put("list", list);
			return SUCCESS;
		}
		public String addcourse(){
			List<Subject> list = ass.findAllEntity();
			ActionContext.getContext().put("list1", list);
			return "addcourse";
		}
		public String addcourse1(){
			Date date=new Date();
			model.setInsert_time(date);
			Subject subject = ass.findEntityById(model.getSubject_id());
			model.setSubject(subject);
			acs.addEntity(model);
			return "addcourse1";
		}
		
		public String updatecourse(){
			System.out.println(id1);
			Course course = acs.findEntityById(id1);
			List<Subject> list = ass.findAllEntity();
			ActionContext.getContext().put("list1", list);
			ActionContext.getContext().put("course", course);
			return "updatecourse";
		}
		public String updatecourse1(){
			Date date=new Date();
			model.setUpdate_time(date);
			Subject subject = ass.findEntityById(model.getSubject_id());
			model.setSubject(subject);
			acs.updateEntity(model);
			return "addcourse1";
		}
		
		public String deletecourse(){
			Course c=new Course();
			c.setId(id1);
			acs.deleteEntity(c);
			return "addcourse1";
		}
}
