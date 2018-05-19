package com.zhiyou100.video.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**  
* @ClassName: MyInterceptor03  
* @Description: TODO
* @author lyb  
* @date 2017年12月25日  下午5:08:01
*  
*/
public class MyInterceptor03 extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		String res="lanjie";
		Object object = ActionContext.getContext().getSession().get("Login_user");
		
		if(object !=null){
		 res = invocation.invoke();
		}
		
		return res;
	}

}
