package com.questions.scenarioBasedQues;

/*
* iven two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

"bxj##tw"
"bxj###tw"



*/
public class BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare("bxj##tw", "bxj###tw"));
    }

    public boolean backspaceCompare(String S, String T) {
        String s1 = getFinalWord(S);
        String t1 = getFinalWord(T);
        return s1.equals(t1);
    }

    public String getFinalWord(String str) {
        StringBuffer sb = new StringBuffer();
        char[] arr = str.toCharArray();
        if (arr.length == 1) {
            if (arr[0] != '#') {

                return String.valueOf(arr[0]);
            } else {
                return "";
            }
        }
        int i = 0;
        int j = i + 1;

        while (j < arr.length && i < arr.length) {
            if (arr[i] == '#') {
                if (sb.length() > 1)
                    sb = new StringBuffer(sb.substring(0, sb.length() - 1));
                else
                    sb = new StringBuffer();
                i++;
                j++;
            } else if (arr[j] == '#') {
                i = i + 2;
                j = i + 1;
            } else {
                sb.append(arr[i]);
                i++;
                j++;
            }

        }
        if (i < arr.length) {
            if (arr[i] != '#') {
                sb.append(arr[i]);
            } else {
                if (sb.length() > 1)
                    sb = new StringBuffer(sb.substring(0, sb.length() - 1));
                else
                    sb = new StringBuffer();
            }
        }
        return sb.toString();
    }
}
