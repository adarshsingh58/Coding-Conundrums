package com.pattern.questions.backtrack;

/**
 * An additive number is a string whose digits can form an additive sequence.
 * <p>
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent
 * number in the sequence must be the sum of the preceding two.
 * <p>
 * Given a string containing only digits, return true if it is an additive number or false otherwise.
 * <p>
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * <p>
 * Example 1:
 * <p>
 * Input: "112358" Output: true Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 1 + 1 = 2, 1 +
 * 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * <p>
 * Example 2:
 * <p>
 * Input: "199100199" Output: true Explanation: The additive sequence is: 1, 99, 100, 199. 1 + 99 = 100, 99 + 100 = 199
 * <p>
 * https://leetcode.com/problems/additive-number/description/
 */
public class AdditiveNumber {
    public static void main(String[] args) {
        String inp = "199100199";
        boolean isAdditive = isAdditive(inp);
        System.out.println(isAdditive);
    }

    private static boolean isAdditive(String inp) {
        for (int i = 1; i < inp.length(); i++) {
            for (int j = i; j < inp.length(); j++) {
                if (isAdditiveRec(inp, 0, i, j, false))
                    return true;
            }
        }
        return false;
    }

    private static boolean isAdditiveRec(String inpArr, int firstStart, int firstEndIndexDelta, int secondEndIndexDelta, boolean found) {
        if (firstStart + firstEndIndexDelta + secondEndIndexDelta == inpArr.length()) {
            found = true;
            return true;
        }
        int firstNum = formNumber(inpArr, firstStart, firstEndIndexDelta);
        int secondNum = formNumber(inpArr, firstEndIndexDelta + 1, secondEndIndexDelta);
        int thirdIndexDelta=findLength(firstNum+secondNum);
        int thirdNum = formNumber(inpArr, secondEndIndexDelta + 1, thirdIndexDelta);
        if (firstNum + secondNum != thirdNum) {
            found = false;
            return false;
        }
        return isAdditiveRec(inpArr, firstStart + firstEndIndexDelta, firstEndIndexDelta, secondEndIndexDelta, found);
    }

    private static int findLength(int num) {
        int count=0;
        while(num!=0){
            num=num/10;
            count++;
        }
        return count;
    }

    private static int formNumber(String inpArr, int firstStart, int firstEndDIndexelta) {
        return Integer.valueOf(inpArr.substring(firstStart,firstStart+firstEndDIndexelta));
    }
}
