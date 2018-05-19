package com.zhiyou100.video.web.action.base;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	
	protected T model;
	@Override
	public T getModel() {
	
		return model;
	}
	public BaseAction() {
		//给model赋值
		//因为子类创建对象的时候会调用子类的空参构造,子类构造方法又会去调用父类的空参构造,所以this指的就是子类
		//superClass就是父类的字节码对象
		//getActualTypeArguments()的到对应字节码对象的泛型,返回值类型是数组,因为一个类可以有多个泛型,就目前这种设计模式而言
		//只有一个泛型,所以通过索引0得到泛型的字节码	对象
		ParameterizedType superClass= (ParameterizedType) this.getClass().getGenericSuperclass();
		
		Class<T> classzz= (Class<T>) superClass.getActualTypeArguments()[0];
		try {
			model=classzz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
