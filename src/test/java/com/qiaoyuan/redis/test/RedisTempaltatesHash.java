package com.qiaoyuan.redis.test;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qiaoyuan.common.utlis.DateUtli;
import com.qiaoyuan.common.utlis.RandomUtli;
import com.qiaoyuan.common.utlis.StringUtil;
import com.qiaoyuan.redis.dimain.User;
/**
 * 
 * @ClassName: RedisTempaltatesHash 
 * @Description: 哈希测试
 * @author:qy
 * @date: 2019年8月12日 上午9:59:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans2.xml")
public class RedisTempaltatesHash {
	@Resource
	private RedisTemplate<String, Serializable> redisTemplate;
	@Test
	public void test_reidsHash() {
		//实例化一个map对象
		Map<String, Serializable> map = new HashMap<>();
		Calendar c = Calendar.getInstance();
		c.set(1960, 0, 1);
		//将100000条数据放到map集合
		for (int i = 1; i <= 100000 ; i++) {
			User user = new User(i,StringUtil.generateChineseName(),StringUtil.randomSex(),"13"+RandomUtli.randomMumbers(9),RandomUtli.randomEmail(3,20)+StringUtil.randomEmail(),DateUtli.getDate(c.getTime()));
			map.put("user_"+i,user);
		}
		//计算存储时间
		long startTime = System.currentTimeMillis();
		redisTemplate.opsForHash().putAll("user",map);
		long endTime = System.currentTimeMillis();
		System.out.println("Hash耗时:"+(endTime-startTime));
		
	}
	
}
