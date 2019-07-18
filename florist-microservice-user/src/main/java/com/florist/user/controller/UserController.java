package com.florist.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.florist.common.pojo.UserInfo;
import com.florist.common.utils.CookieUtils;
import com.florist.common.vo.SysResult;
import com.florist.user.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/user/manage/register")
	public SysResult register(UserInfo userInfo){
		try {
			userService.register(userInfo);
			return SysResult.ok();
		} catch (Exception e) {
			return SysResult.build(201, e.getMessage(), null);
		}
	}
	
	@RequestMapping("/user/manage/login")
	public SysResult login(String username,String password,HttpServletRequest request,HttpServletResponse response){
		String ticket = userService.login(username, password);
		if(StringUtils.isNotEmpty(ticket)){
			CookieUtils.setCookie(request, response, "TICKET", ticket);
			System.out.println("登录成功");
			return SysResult.ok();
		}else {
			return SysResult.build(201, "失败", null);
		}
	}
	
	@RequestMapping("/user/manage/query")
	public SysResult query(String ticket){
		String userJson = userService.queryUser(ticket);
		if(StringUtils.isNotEmpty(userJson)){
			return SysResult.build(200, "ok", userJson);
		}else{
			return SysResult.build(201, "", null);
		}
	}
	
	@RequestMapping("/user/manage/logout")
	public SysResult logout(HttpServletRequest request){
		String ticket = CookieUtils.getCookieValue(request, "TICKET");
		try {
			userService.logout(ticket);
			return SysResult.ok();
		} catch (Exception e) {
			return SysResult.build(201, e.getMessage(), null);
		}
	}
	
	@RequestMapping("/user/manage/update")
	public SysResult update(UserInfo userInfo){
		try {
			userService.update(userInfo);
			return SysResult.ok();
		} catch (Exception e) {
			return SysResult.build(201, e.getMessage(), null);
		}
	}
}
