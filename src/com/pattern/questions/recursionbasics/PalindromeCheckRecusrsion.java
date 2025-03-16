package com.pattern.questions.recursionbasics;

public class PalindromeCheckRecusrsion {

    public static void main(String[] args) {
        String inp="MADAM";
        boolean op=checkPalindrome(inp);
        System.out.println(op);
    }

    private static boolean checkPalindrome(String inp) {
        return checkPalindromeRec(inp.toCharArray(),0);
    }

    private static boolean checkPalindromeRec(char[] inp, int i) {
        if(i>=(inp.length-1-i)){
            return true;
        }
        if(inp[i]!=inp[inp.length-1-i])
            return false;
        return checkPalindromeRec(inp,i+1);
    }


}
