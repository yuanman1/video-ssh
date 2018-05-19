package com.zhiyou100.video.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.AdminCourseService;
import com.zhiyou100.video.service.AdminVideoService;
import com.zhiyou100.video.web.action.base.BaseAction;
@Controller
@Scope(scopeName="prototype")
public class AdminStatisticsAction extends ActionSupport{
	@Autowired
	private AdminCourseService acs;
	public String statisticsList(){
		List<Course> list = acs.findAllEntity();
		ActionContext.getContext().put("course", list);
		System.out.println(list);
		List<Integer> list1=new ArrayList<Integer>();
		for (Course course : list) {
			Integer a=0;
			int b=0;
			Set<Video> videos = course.getVideos();
			for (Video video : videos) {
				a+=video.getVideo_play_times();
				b+=1;
			}
			Integer avg=a/b;
			list1.add(avg);
		}
		ActionContext.getContext().put("times", list1);
		return SUCCESS;
	}
}
