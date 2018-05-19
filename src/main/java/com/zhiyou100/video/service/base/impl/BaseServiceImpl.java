package com.zhiyou100.video.service.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhiyou100.video.dao.base.BaseDao;
import com.zhiyou100.video.service.base.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {
	 @Autowired
	 private BaseDao<T> dao; 
	public BaseDao<T> getDao() {
		return dao;
	}
	@Autowired
	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	@Override
	public void addEntity(T entity) {
		dao.addEntity(entity);

	}

	@Override
	public void deleteEntity(T entity) {
		dao.deleteEntity(entity);

	}

	@Override
	public void updateEntity(T entity) {
		dao.updateEntity(entity);

	}

	@Override
	public T findEntityById(Serializable id) {
		// TODO Auto-generated method stub
		return dao.findEntityById(id);
	}

	@Override
	public List<T> findAllEntity() {
		List<T> list = dao.findAllEntity();
		return list;
	}

}
