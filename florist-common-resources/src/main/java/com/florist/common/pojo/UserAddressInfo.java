package com.florist.common.pojo;

public class UserAddressInfo {
	private Integer addressId;
	private Integer userId;
	private String userRealName;
	private String userPhone;
	private String userAddress;
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	@Override
	public String toString() {
		return "UserAddressInfo [addressId=" + addressId + ", userId=" + userId + ", userRealName=" + userRealName
				+ ", userPhone=" + userPhone + ", userAddress=" + userAddress + "]";
	}
	
	
}
