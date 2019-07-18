package com.florist.announcement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florist.announcement.mapper.AnnouncementMapper;
import com.florist.common.pojo.AnnouncementInfo;

@Service
public class AnnouncementService {
	
	@Autowired
	private AnnouncementMapper mapper;

	public List<AnnouncementInfo> showAll() {
		return mapper.showAll();
	}
	public AnnouncementInfo showById(String announcementId) {
		return mapper.showById(announcementId);
	}
}
