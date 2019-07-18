package com.florist.user.mapper;

import org.apache.ibatis.annotations.Param;

import com.florist.common.pojo.UserInfo;

public interface UserMapper {

	public void userAdd(UserInfo userInfo);

	public UserInfo queryUserbyNameAndPassword(@Param("userName") String userName, @Param("userPassword")String userPassword);

	public void userUpate(UserInfo userInfo);

}
