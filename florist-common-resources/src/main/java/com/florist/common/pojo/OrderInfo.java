package com.florist.common.pojo;

import java.math.BigDecimal;

public class OrderInfo {
	private Long orderId;
	private Integer orderStatus;
	private Integer userId;
	private String userRealName;
	private String userPhone;
	private String userAddress;
	private String orderDetail;
	private String orderRemark;
	private String orderDistributeTime;
	private BigDecimal orderTotalPrice;
	private Integer productId;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
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
	public String getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(String orderDetail) {
		this.orderDetail = orderDetail;
	}
	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	public String getOrderDistributeTime() {
		return orderDistributeTime;
	}
	public void setOrderDistributeTime(String orderDistributeTime) {
		this.orderDistributeTime = orderDistributeTime;
	}
	public BigDecimal getOrderTotalPrice() {
		return orderTotalPrice;
	}
	public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", orderStatus=" + orderStatus + ", userId=" + userId
				+ ", userRealName=" + userRealName + ", userPhone=" + userPhone + ", userAddress=" + userAddress
				+ ", orderDetail=" + orderDetail + ", orderRemark=" + orderRemark + ", orderDistributeTime="
				+ orderDistributeTime + ", orderTotalPrice=" + orderTotalPrice + "]";
	}
	
	
	
}
