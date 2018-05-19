package com.zhiyou100.video.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.zhiyou100.video.dao.AdminVideoDao;
import com.zhiyou100.video.dao.base.impl.BaseDaoImpl;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Video;
@Repository
public class AdminVideoDaoImpl extends BaseDaoImpl<Video> implements AdminVideoDao{

	@Override
	public int findpageVideocount(String speaker_id, String course_id,String video_title) {
		List<Video> list1= getHibernateTemplate().execute(new HibernateCallback<List<Video>>() {
			@Override
			public List<Video> doInHibernate(Session session) throws HibernateException {
				String sql1="SELECT * FROM video v LEFT JOIN speaker s on v.speaker_id=s.id LEFT JOIN course c ON v.course_id=c.id where v.video_title LIKE '%"+video_title+"%' AND s.speaker_name like '%"+speaker_id+"%' AND c.course_name like '%"+course_id+"%'";
				List<Video> list = session.createSQLQuery(sql1).addEntity(Video.class).list();
				
				return list;
			}
		});
		return list1.size();
	}

	@Override
	public List<Video> findpageVideoList(int page1, String speaker_id, String course_id, String video_title) {
		String page=page1+"";
		List<Video> list =getHibernateTemplate().execute(new HibernateCallback<List<Video>>() {

			@Override
			public List<Video> doInHibernate(Session session) throws HibernateException {
				String sql1="SELECT * FROM video v LEFT JOIN speaker s on v.speaker_id=s.id LEFT JOIN course c ON v.course_id=c.id where v.video_title LIKE '%"+video_title+"%' AND s.speaker_name like '%"+speaker_id+"%' AND c.course_name like '%"+course_id+"%' limit "+page+",5";
				List<Video> list1 = session.createSQLQuery(sql1).addEntity(Video.class).list();
				
				return list1;
				
			}
		});
		return list;
	}

	@Override
	public Video findvideoList(Integer videoId) {
		List<Video> find = (List<Video>) getHibernateTemplate().find("from Video where id=?", videoId);
		if(find.isEmpty()){
			return null;
		}
		return find.get(0);
	}

}
