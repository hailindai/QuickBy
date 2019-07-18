package com.florist.common.pojo;

import java.io.Serializable;

public class AnnouncementInfo implements Serializable{
	private Integer announcementId;
	private String  announcementTitle;
	private String announcementDescription;
	private String announcementDistributeTime;
	public Integer getAnnouncementId() {
		return announcementId;
	}
	public void setAnnouncementId(Integer announcementId) {
		this.announcementId = announcementId;
	}
	public String getAnnouncementTitle() {
		return announcementTitle;
	}
	public void setAnnouncementTitle(String announcementTitle) {
		this.announcementTitle = announcementTitle;
	}
	public String getAnnouncementDescription() {
		return announcementDescription;
	}
	public void setAnnouncementDescription(String announcementDescription) {
		this.announcementDescription = announcementDescription;
	}
	public String getAnnouncementDistributeTime() {
		return announcementDistributeTime;
	}
	public void setAnnouncementDistributeTime(String announcementDistributeTime) {
		this.announcementDistributeTime = announcementDistributeTime;
	}
	@Override
	public String toString() {
		return "AnnouncementInfo [announcementId=" + announcementId + ", announcementTitle=" + announcementTitle
				+ ", announcementDescription=" + announcementDescription + ", announcementDistributeTime="
				+ announcementDistributeTime + "]";
	}
	
	
	
}
