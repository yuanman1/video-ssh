package com.zhiyou100.video.web.action;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.AdminVideoService;
import com.zhiyou100.video.web.action.base.BaseAction;
@Controller
@Scope(scopeName="prototype")
public class FrontVideoAction extends BaseAction<Video>{
		private Integer videoId;
		private Integer subjectId;
		public Integer getVideoId() {
			return videoId;
		}
		public void setVideoId(Integer videoId) {
			this.videoId = videoId;
		}
		public Integer getSubjectId() {
			return subjectId;
		}
		public void setSubjectId(Integer subjectId) {
			this.subjectId = subjectId;
		}
		@Autowired
		private AdminVideoService avs;
		public String frontVideo(){
			Video video=avs.findvideoList(videoId);
			Set<Video> set = video.getCourses().getVideos();
			for (Video video2 : set) {
				video2.setSpeaker_name(video2.getSpeakers().getSpeaker_name());
			}
			ActionContext.getContext().put("subjectId",subjectId);
			ActionContext.getContext().put("course", video.getCourses());
			ActionContext.getContext().put("video", video);
			ActionContext.getContext().put("speaker", video.getSpeakers());
			ActionContext.getContext().put("videoList", video.getCourses().getVideos());
			return SUCCESS;
		}
}
