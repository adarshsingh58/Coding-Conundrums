package com.OtherPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortingMapByValues {

	public static void main(String[] args) {
		Map<String, Integer> studentMarks=new LinkedHashMap<>();
		studentMarks.put("Adarsh",98);
		studentMarks.put("Jabka",14);
		studentMarks.put("Loiu",63);
		studentMarks.put("Sukna",78);
		studentMarks.put("Bakka",23);
		System.out.println(studentMarks);
		studentMarks=sortByValue(studentMarks);
		System.out.println(studentMarks);
	}

	private static Map<String, Integer>  sortByValue(Map<String, Integer> studentMarks) {
		List<Map.Entry<String, Integer>> list=new ArrayList<>();
		for(Map.Entry<String, Integer> e:studentMarks.entrySet()) {
			list.add(e);
		}
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(o1.getValue()>o2.getValue()) {
					return 1;
				}else if(o1.getValue()<o2.getValue()) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		studentMarks=new LinkedHashMap<>();
		for(Map.Entry<String, Integer> e:list) {
			studentMarks.put(e.getKey(), e.getValue());
		}
		return studentMarks;
	}
}
