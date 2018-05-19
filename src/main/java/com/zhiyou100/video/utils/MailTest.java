package com.zhiyou100.video.utils;

import org.junit.Test;

public class MailTest {
	@Test
	public void test01() throws Exception{
	/*
	*
	* <a href=\"http://www.baidu.co
	m\">百度</a>
	*/
	MailUtil.send("1412668325@qq.com", "测试邮件", "<a href=\"http://www.baidu.com\">百度</a>");
	/*
	* 0. MD5(邮箱+密码+当前时间)就是激活
	码  24小时有效
	* 1.id(uuid)  邮箱地址   状态(0未
	激活,1表示激活)   激活码     失效时间
	* 2.http://localhost:8080/Test/M
	ail/active.action?id=id&activeCode=激活码
	*/
	}
}
