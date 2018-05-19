package com.zhiyou100.video.web.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.AdminSpeakerService;
import com.zhiyou100.video.utils.Page;
import com.zhiyou100.video.web.action.base.BaseAction;
@Controller
@Scope(scopeName="prototype")
public class AdminSpeakerAction extends BaseAction<Speaker>{
	@Autowired
	private AdminSpeakerService ass;
	private Integer id1;
	public Integer getId1() {
		return id1;
	}
	public void setId1(Integer id1) {
		this.id1 = id1;
	}
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	public String speakerList(){
		/*page=page==0?1:page;
		userKeyWordname = userKeyWordname==null?"":userKeyWordname;
		userKeyWordjob = userKeyWordjob==null?"":userKeyWordjob;*/
		page=page==0?1:page;
		String speaker_name=model.getSpeaker_name()==null?"":model.getSpeaker_name();
		String speaker_job=model.getSpeaker_job()==null?"":model.getSpeaker_job();
		Page<Speaker> pa=ass.findpageTRoleSpeaker(page,speaker_name,speaker_job);
		ActionContext.getContext().put("page", pa);
		ActionContext.getContext().put("speaker_name", speaker_name);
		ActionContext.getContext().put("speaker_job", speaker_job);
		return SUCCESS;
	}
	public String addspeaker(){
		return "addspeaker";
	}
	public String addspeaker1(){
		Date date=new Date();
		model.setInsert_time(date);
		ass.addEntity(model);
		return "allspeaker";
	}
	public String updatespeaker(){
		Speaker speaker = ass.findEntityById(id1);
		ActionContext.getContext().put("speaker", speaker);
		return "updatespeaker";
	}
	public String updatespeaker1(){
		Date date=new Date();
		model.setUpdate_time(date);
		ass.updateEntity(model);
		return "allspeaker";
	}
	public String deletespeaker(){
		Speaker s=new Speaker();
		s.setId(id1);
		ass.deleteEntity(s);
		return "allspeaker";
	}
}
