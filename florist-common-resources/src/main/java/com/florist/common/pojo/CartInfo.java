package com.florist.common.pojo;

import java.math.BigDecimal;

public class CartInfo {
	private Integer cartId;
	private Integer userId;
	private Integer productId;
	private String productName;
	private Integer productCount;
	private BigDecimal totalPrice;
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductCount() {
		return productCount;
	}
	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "CartInfo [cartId=" + cartId + ", userId=" + userId + ", productId=" + productId + ", productName="
				+ productName + ", productCount=" + productCount + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
