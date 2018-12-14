package com.array.conundrums.rotation;

import java.util.HashMap;
import java.util.Map;

public class FindingDuplicateElements {

	public static void main(String[] args) {
		int[] inputArr = { 1, 1, 8, 5,5, 1 };
		findDuplicate_ViaMap(inputArr);
	}

	public static Map<Integer, Integer> findDuplicate_ViaMap(int[] inputArr) {
		int maxSize=0;
		
		Map<Integer,Integer> map=new HashMap<>();
		for(Integer i:inputArr){
			if(map.get(i)!=null){
				Integer value=map.get(i);
				map.put(i, ++value);
			}else{
				map.put(i,1);
			}
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				System.out.println(entry.getKey()+": count :"+entry.getValue());
		}
		return map;
	}
}
