package com.test.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.dto.ResultDTO;
import com.test.entity.Labels;
import com.test.entity.LabelsExample;
import com.test.mapper.LabelsMapper;
import com.test.utils.MyException;
@CacheConfig(cacheNames={"labels"})
@Controller
public class LabelsController {
	@Autowired
	CacheManager cacheManager;
	
	@Autowired
	private LabelsMapper mapper;
	@ResponseBody
	@PostMapping("/labels")
private  Object getLabels(Model model){
	LabelsExample example = new LabelsExample();
	List<Labels> selectByExample = mapper.selectByExample(example);
	Cache cache = cacheManager.getCache("labels");
	cache.put("labels", selectByExample);
	return new ResultDTO(2005, "成功", selectByExample);
}
	@ResponseBody
	@PostMapping("/labels/{id}")
private  Object getLabel(Model model,@PathVariable("id") String id){
	   if(StringUtils.isEmpty(id)){
		 throw new MyException("访问的标签不存在！！！")  ;
	   }
		Labels selectByPrimaryKey = mapper.selectByPrimaryKey(Integer.parseInt(id));
		String[] split = selectByPrimaryKey.getLabelCategory().split(",");
		List<String> asList = Arrays.asList(split);
	return new ResultDTO(2005, "成功",asList );
}
}
