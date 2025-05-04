package com;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        int[] inp=new int[]{1,2,5};
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((v1,v2)->{
            return v2.getValue()-v1.getValue();
        });
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num))
                map.put(num, map.get(num)+1);
            else
                map.put(num, 1);
        }

        for(Map.Entry<Integer,Integer> es:map.entrySet()){
            pq.add(es);
        }

        int[] op=new int[k];
        for(int i=0;i<k;i++)
            op[i]=pq.poll().getKey();

        return op;

    }
}
