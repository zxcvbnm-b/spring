package com.test.web;

import java.util.Map;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.dto.MapDTO;
import com.test.mapper.QuestionMapper;

@Controller
public class HostTopicController {
	@Autowired
	private QuestionMapper mapper;
	@Autowired
	private MapDTO map;
	@RequestMapping("test")
private String HostTopic() throws SchedulerException{
Map map1 = map.getMap1();
Map map2 = map.getMap2();
System.out.println(map1);
System.out.println(map2);
		
	return null;
   }
}
