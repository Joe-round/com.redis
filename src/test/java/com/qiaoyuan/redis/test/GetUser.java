package com.qiaoyuan.redis.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.qiaoyuan.common.utlis.DateUtli;
import com.qiaoyuan.common.utlis.RandomUtli;
import com.qiaoyuan.common.utlis.StringUtil;
import com.qiaoyuan.redis.dimain.User;
/**
 * 
 * @ClassName: GetUser 
 * @Description: user工具
 * @author:qy
 * @date: 2019年8月12日 上午9:51:59
 */
public  class GetUser {

/**
 * 
 * @Title: getUser 
 * @Description: 随机获取100000哥user对象并放到list集合中
 * @return
 * @return: List
 */
	public static List getUser() {
		List<User> users = new ArrayList<>();
		Calendar c = Calendar.getInstance();
		c.set(1960, 0, 1);
		for (int i = 1; i <=100000 ; i++) {
			User user = new User(i,StringUtil.generateChineseName(),StringUtil.randomSex(),"13"+RandomUtli.randomMumbers(9),RandomUtli.randomEmail(3,20)+StringUtil.randomEmail(),DateUtli.getDate(c.getTime()));
			users.add(user);
		}
		return users;
	}
}
