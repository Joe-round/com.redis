package com.qiaoyuan.redis.test;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qiaoyuan.redis.dimain.User;
/**
 * 
 * @ClassName: RedisTemplatesStringJdk 
 * @Description: 测试String类型Jdk存储方式
 * @author:qy
 * @date: 2019年8月12日 上午9:52:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class RedisTemplatesStringJdk {
	@Resource
	private RedisTemplate<String, Serializable> redisTemplate;
	@Test
	public void test_stringJdk() {
		List<User> list = GetUser.getUser();
		//计算存储时间
		long startTime = System.currentTimeMillis();
		for (User user : list) {
			redisTemplate.opsForValue().set("user_"+user.getId(), user);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("StringJdk耗时:"+(endTime-startTime));
	}
}
