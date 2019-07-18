package com.florist.user.service;

import java.io.IOException;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.florist.common.pojo.UserInfo;
import com.florist.common.utils.MD5Util;
import com.florist.common.utils.MapperUtil;
import com.florist.user.mapper.UserMapper;

import redis.clients.jedis.JedisCluster;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	private ObjectMapper mapper = MapperUtil.MP;	
	
	@Autowired
	private JedisCluster redis;
	
	public void register(UserInfo userInfo) {
		String md5Password = MD5Util.md5(userInfo.getUserPassword());
		userInfo.setUserPassword(md5Password);
		userMapper.userAdd(userInfo);
		
	}

	public String login(String username, String password) {
		
		try{
			UserInfo exist = userMapper.queryUserbyNameAndPassword(username,MD5Util.md5(password));
			if(exist == null){
				return "";
			}else {
				String ticket = UUID.randomUUID().toString();
				String userJson;
				userJson = mapper.writeValueAsString(exist);
				String existTicket  = redis.get("user_logined_"+exist.getUserName());//判断是否登录
				if(StringUtils.isNotEmpty(existTicket)){
					redis.del(existTicket);
				}
				redis.setex("user_logined_"+exist.getUserName(),60*30, ticket);//设置登录时间
				redis.set(ticket, userJson);//保存用户信息
				return ticket;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {
			
		}
		
	}

	public String queryUser(String ticket) {
		String userJson="";
		try {
			userJson = redis.get(ticket);
			Long leftTime = redis.pttl(ticket);
			if(leftTime < 60*10*1000){
				redis.pexpire(ticket,leftTime + 60*5*1000);
			}
			return userJson;
		} catch (Exception e) {
			return "";
		}finally {
		}
	}

	public void logout(String ticket) {
		redis.del(ticket);
		
	}

	public void update(UserInfo userInfo) {
		
		String existTicket  = redis.get("user_logined_"+userInfo.getUserName());//判断是否登录
		if(StringUtils.isNotEmpty(existTicket)){
			String userJson = redis.get(existTicket);
			try {
				UserInfo readValue = mapper.readValue(userJson, UserInfo.class);
				readValue.setUserAddress(userInfo.getUserAddress());
				readValue.setUserRealName(userInfo.getUserRealName());
				readValue.setUserPhone(userInfo.getUserPhone());
				String result = mapper.writeValueAsString(readValue);
				redis.set(existTicket, result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String md5Password = MD5Util.md5(userInfo.getUserPassword());
		userInfo.setUserPassword(md5Password);
		userMapper.userUpate(userInfo);
		
	}
	
}
