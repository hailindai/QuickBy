package com.florist.common.pojo;

import java.math.BigDecimal;

public class ProductInfo {
	private Integer productId;
	private String productName;
	private String productImagePath;
	private Integer sortId;
	private String sortName;
	private BigDecimal productPrice;
	private Integer recommendationLevel;
	private Integer productHeat;	//
	private Integer productSellCount;
	private String productDescription;  //text 注意
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
	public String getProductImagePath() {
		return productImagePath;
	}
	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}
	public Integer getSortId() {
		return sortId;
	}
	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getRecommendationLevel() {
		return recommendationLevel;
	}
	public void setRecommendationLevel(Integer recommendationLevel) {
		this.recommendationLevel = recommendationLevel;
	}
	public Integer getProductHeat() {
		return productHeat;
	}
	public void setProductHeat(Integer productHeat) {
		this.productHeat = productHeat;
	}
	public Integer getProductSellCount() {
		return productSellCount;
	}
	public void setProductSellCount(Integer productSellCount) {
		this.productSellCount = productSellCount;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	@Override
	public String toString() {
		return "ProductInfo [productId=" + productId + ", productName=" + productName + ", productImagePath="
				+ productImagePath + ", sortId=" + sortId + ", sortName=" + sortName + ", productPrice=" + productPrice
				+ ", recommendationLevel=" + recommendationLevel + ", productHeat=" + productHeat
				+ ", productSellCount=" + productSellCount + ", productDescription=" + productDescription + "]";
	}
	
}
