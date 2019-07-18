package com.florist.announcement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.florist.announcement.service.AnnouncementService;
import com.florist.common.pojo.AnnouncementInfo;
import com.florist.common.vo.AnnouncementInfoUIResult;

@RestController
public class AnnouncementController {
	
	@Autowired
	private AnnouncementService service;
	@RequestMapping("/announcement/manage/showall")
	public AnnouncementInfoUIResult showAll(){
		AnnouncementInfoUIResult result = new AnnouncementInfoUIResult();
		List<AnnouncementInfo> list = service.showAll();
		result.setRows(list);
		result.setTotal(list.size());
		return result;
	}
	
	@RequestMapping("/announcement/manage/show")
	public AnnouncementInfo showById(String id){
		AnnouncementInfo announcementInfo = service.showById(id);
		return announcementInfo;
	}
	
}
