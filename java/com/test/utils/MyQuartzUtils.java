package com.test.utils;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.test.dto.MapDTO;
import com.test.entity.Question;
import com.test.entity.QuestionExample;
import com.test.mapper.QuestionMapper;
//定时任务：定时推送相关问题和标签
@Component
public class MyQuartzUtils {
	@Autowired
	private QuestionMapper mapper;
	@Autowired
	private MapDTO mapdto;
	 /* @Scheduled(fixedRate = 5000)每隔5秒执行一次*/
	@Scheduled(fixedRate = 1000*60*60*24)
	 /* @Scheduled(cron = "0 10 11 ? * *")每天11点10分执行一次，如果重启后，不到这个时间，不查询，那么页面也没有数据*/
	    public void reportCurrentTime() {
		  Map<String,Integer> LabelMap=mapdto.getMap1();//计算标签使用次数最多的几个标签
			 Map<Double, Question> questions=new LinkedHashMap<>();
			 questions=mapdto.getMap2();
			List<Question> selectByExample = mapper.selectByExample(new QuestionExample());
			for (Question question : selectByExample) {

				questions.put((double) ((question.getBrowse()+question.getReply()*3)), question);

			    String describes = question.getDescribes();
			    String[] split = describes.split(",");
			    for (int i = 0; i < split.length; i++) {
					if(!LabelMap.containsKey(split[i])){
						LabelMap.put(split[i],1);
					}else{
					Integer integer = LabelMap.get(split[i])+1;
					LabelMap.put(split[i], integer);
					}
				}
			}
		
	    }
	
}
