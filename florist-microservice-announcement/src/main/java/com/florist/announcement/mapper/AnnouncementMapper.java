package com.florist.announcement.mapper;

import java.util.List;

import com.florist.common.pojo.AnnouncementInfo;

public interface AnnouncementMapper {

	List<AnnouncementInfo> showAll();

	AnnouncementInfo showById(String announcementId);
}
