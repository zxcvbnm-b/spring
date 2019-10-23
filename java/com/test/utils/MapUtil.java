package com.test.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MapUtil {
	  public static Map sortMap(Map oldMap) {     
		  
          ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(oldMap.entrySet());     
          Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {     
     
              @Override     
              public int compare(Entry<java.lang.String, Integer> arg0,     
                      Entry<java.lang.String, Integer> arg1) {     
                  return arg0.getValue() - arg1.getValue();     
              }     
          });     
          Map newMap = new LinkedHashMap();     
          for (int i = 0; i < list.size(); i++) {     
              newMap.put(list.get(i).getKey(), list.get(i).getValue());     
          }     
          return newMap;     
      }  
	  public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueDescending(Map<K, V> map)
	    {
	        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
	        Collections.sort(list, new Comparator<Map.Entry<K, V>>()
	        {
	            @Override
	            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2)
	            {
	                int compare = (o1.getValue()).compareTo(o2.getValue());
	                return -compare;
	            }
	        });
	 
	        Map<K, V> result = new LinkedHashMap<K, V>();
	        for (Map.Entry<K, V> entry : list) {
	            result.put(entry.getKey(), entry.getValue());
	        }
	        return result;
	    }
	  /**
	     * ¸ù¾ÝmapµÄkeyÅÅÐò
	     * 
	     * @param map ´ýÅÅÐòµÄmap
	     * @param isDesc ÊÇ·ñ½µÐò£¬true£º½µÐò£¬false£ºÉýÐò
	     * @return ÅÅÐòºÃµÄmap
	     * @author zero 2019/04/08
	     */
	  public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map, boolean isDesc) {
	        Map<K, V> result = new LinkedHashMap();
	        if (isDesc) {
	            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey().reversed())
	                .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
	        } else {
	            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey())
	                .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
	        }
	        return result;
	    }
  }     


