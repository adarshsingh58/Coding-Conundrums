package com;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Set s=new HashSet();
        List<Integer> list=new ArrayList<>();
        list.stream().reduce((v1,v2)-> v1+v2).get();
    }

}
