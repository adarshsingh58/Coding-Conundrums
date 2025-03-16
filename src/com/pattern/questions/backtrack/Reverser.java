package com.pattern.questions.backtrack;

public class Reverser {

    public static void main(String[] args) {

        // should be "dlrow olleh"
        System.out.println("hello world -> " + Reverser.reverse("hello world"));

        // should be "olleh"
        System.out.println("hello -> " + Reverser.reverse("hello"));

        // should be "9876543210"
        System.out.println("0123456789 -> " + Reverser.reverse("0123456789"));
    }

    public static String reverse(String string) {

        // * Base Case
        if (string.length() <= 1) return string;

        return string.charAt(string.length() - 1) + reverse(string.substring(0, string.length() - 1));
    }
}
