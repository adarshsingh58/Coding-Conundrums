package com.DataStructures_And_Questions.Stack;

import java.util.Stack;

/*
*Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"


* https://leetcode.com/problems/decode-string
* */
public class DecodeString {

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
    }

    public String decodeString(String s) {
        java.util.Stack<String> charstack=new Stack<>();
        StringBuilder sb=new StringBuilder();

        char[] cA=s.toCharArray();
        for(int i=0;i< cA.length;i++){
            if(cA[i]!=']'){
                charstack.push(cA[i]+"");
            }else{
                StringBuilder word=new StringBuilder();
                while(!charstack.isEmpty() && !charstack.peek().equals("[")){
                    word.insert(0,charstack.pop());
                }
                StringBuilder num=new StringBuilder();
                if(!charstack.isEmpty()) charstack.pop();
                while(!charstack.isEmpty() &&Character.isDigit(charstack.peek().charAt(0))){
                    num.insert(0,charstack.pop());
                }
                String w=word.toString();
                Integer n=Integer.parseInt(num.toString());
                while(n!=1){
                    word.append(w);
                    n--;
                }
                charstack.push(word.toString());
            }
        }
        while(!charstack.isEmpty())sb.insert(0,charstack.pop());
        return sb.toString();
    }

}
