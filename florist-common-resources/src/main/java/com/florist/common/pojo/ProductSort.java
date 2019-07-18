package com.florist.common.pojo;

public class ProductSort {
	private Integer sortId;
	private String sortName;
	private Integer sortCount;
	private Integer sortHeat;
	private Integer sortSellCount;
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
	public Integer getSortCount() {
		return sortCount;
	}
	public void setSortCount(Integer sortCount) {
		this.sortCount = sortCount;
	}
	public Integer getSortHeat() {
		return sortHeat;
	}
	public void setSortHeat(Integer sortHeat) {
		this.sortHeat = sortHeat;
	}
	public Integer getSortSellCount() {
		return sortSellCount;
	}
	public void setSortSellCount(Integer sortSellCount) {
		this.sortSellCount = sortSellCount;
	}
	@Override
	public String toString() {
		return "ProductSort [sortId=" + sortId + ", sortName=" + sortName + ", sortCount=" + sortCount + ", sortHeat="
				+ sortHeat + ", sortSellCount=" + sortSellCount + "]";
	}
	
	
}
