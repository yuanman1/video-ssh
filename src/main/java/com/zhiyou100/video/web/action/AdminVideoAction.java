package com.zhiyou100.video.web.action;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.AdminCourseService;
import com.zhiyou100.video.service.AdminSpeakerService;
import com.zhiyou100.video.service.AdminVideoService;
import com.zhiyou100.video.utils.Page;
import com.zhiyou100.video.web.action.base.BaseAction;
@Controller
@Scope(scopeName="prototype")
public class AdminVideoAction extends BaseAction<Video>{
	@Autowired
	private AdminVideoService avs;
	@Autowired
	private AdminCourseService acs;
	@Autowired
	private AdminSpeakerService ass;
	private Integer[] id2;
	
	public Integer[] getId2() {
		return id2;
	}
	public void setId2(Integer[] id2) {
		this.id2 = id2;
	}
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	private Integer id1;
	public Integer getId1() {
		return id1;
	}
	public void setId1(Integer id1) {
		this.id1 = id1;
	}
	public String videoList(){
		page=page==0?1:page;
		String speaker_name=model.getSpeaker_name()==null?"":model.getSpeaker_name();
		String course_name=model.getCourse_name()==null?"":model.getCourse_name();
	    String video_title= model.getVideo_title()==null?"":model.getVideo_title();
	    Page<Video> pa=avs.findpageVideo(page,speaker_name,course_name,video_title);
		List<Course> listcourse = acs.findAllEntity();
		List<Speaker> listspeaker = ass.findAllEntity();
		ActionContext.getContext().put("page", pa);
		ActionContext.getContext().put("course", listcourse);
		ActionContext.getContext().put("speaker", listspeaker);
		return SUCCESS;
	}
	public String addvideo(){
		List<Course> listcourse = acs.findAllEntity();
		List<Speaker> listspeaker = ass.findAllEntity();
		ActionContext.getContext().put("course", listcourse);
		ActionContext.getContext().put("speaker", listspeaker);
		return "addvideo";
	}
	public String addvideo1(){
		model.setSpeakers(ass.findEntityById(model.getSpeaker_id()));
		model.setCourses(acs.findEntityById(model.getCourse_id()));
		Date date=new Date();
		model.setInsert_time(date);
		avs.addEntity(model);
		return "allvideo";
	}
	public String updatevideo(){
		List<Course> listcourse = acs.findAllEntity();
		List<Speaker> listspeaker = ass.findAllEntity();
		Video video = avs.findEntityById(id1);
		
		ActionContext.getContext().put("video", video);
		ActionContext.getContext().put("course", listcourse);
		ActionContext.getContext().put("speaker", listspeaker);
		return "updatevideo";
	}
	public String updatevideo1(){
		Date date=new Date();
		model.setUpdate_time(date);
		model.setSpeakers(ass.findEntityById(model.getSpeaker_id()));
		model.setCourses(acs.findEntityById(model.getCourse_id()));
		avs.updateEntity(model);
		return "allvideo";
	}
	public String deletevideo(){
		Video v=new Video();
		v.setId(id1);
		avs.deleteEntity(v);
		return "allvideo";
	}
	
	public String deleteallvideo(){
		for (Integer integer : id2) {
			Video v=new Video();
			v.setId(integer);
			avs.deleteEntity(v);
		}
		return "allvideo";
	}
	
	
	
	
	
	
	
	
}
