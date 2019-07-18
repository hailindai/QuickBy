package com.florist.common.pojo;

public class UserInfo {
	private Integer userId;
	private String userName;
	private String userPassword;
	private Integer userLevel;
	private String userRealName;
	private String userPhone;
	private String userAddress;
	private Integer historyOrderCount;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Integer getHistoryOrderCount() {
		return historyOrderCount;
	}
	public void setHistoryOrderCount(Integer historyOrderCount) {
		this.historyOrderCount = historyOrderCount;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userLevel=" + userLevel + ", userRealName=" + userRealName + ", userPhone=" + userPhone
				+ ", userAddress=" + userAddress + ", historyOrderCount=" + historyOrderCount + "]";
	}
	
	
	
}
