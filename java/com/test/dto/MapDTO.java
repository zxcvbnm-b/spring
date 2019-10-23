package com.test.dto;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import com.test.entity.Question;

import lombok.Data;
@Data
@Component
public class MapDTO {
private static Map map1=new HashMap<>();
TreeMap<Double,Question> map2= new TreeMap<Double,Question>();
public synchronized Map  getMap1(){
	return map1;
}
public synchronized TreeMap<Double, Question>  getMap2(){
	return map2;
}
}
