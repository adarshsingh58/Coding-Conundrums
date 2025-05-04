package com.DataStructures_And_Questions.OtherPrograms;

/**
 * Given a string we can perform insert, remove or replace on its char.
 * If we have 2 strings, find if they are one edit away
 * eg:
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class OneEditAway {
    public static void main(String[] args) {
        String inp1 = "pale";
        String inp2 = "pape";
        System.out.println(isOneEditAway(inp1, inp2));
    }

    private static boolean isOneEditAway(String inp1, String inp2) {
        if (Math.abs(inp1.length() - inp2.length()) <= 1) {
            if (inp1.length() - inp2.length() > 0) {
                return findEditAway(inp1, inp2, 1);
            } else if (inp1.length() - inp2.length() < 0) {
                return findEditAway(inp2, inp1, 1);
            } else {
                return findEditAway_equal(inp1, inp2, 1);
            }
        } else {
            return false;
        }
    }

    private static boolean findEditAway_equal(String inp1, String inp2, int numberOfEdits) {
        int diff = 0;
        for (int i = 0; i < inp1.length(); i++) {
            if (inp1.charAt(i) != inp2.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean findEditAway(String largeString, String smallString, int numberOfEdits) {
        int diff = 0;
        for (int i = 0, j = 0; i < smallString.length(); ) {
            if (largeString.charAt(i) != smallString.charAt(j)) {
                diff++;
                i++;
                if (diff > 1) {
                    return false;
                }
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
}
