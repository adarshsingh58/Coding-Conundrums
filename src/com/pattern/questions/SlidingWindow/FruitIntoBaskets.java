package com.pattern.questions.SlidingWindow;

/**
 * While visiting a farm of fruits, you have been given a row of fruits represented by an integer array, fruits, where fruits[i] is the type of fruit the ithith tree produces. You have to collect fruits, but there are some rules that you must follow while collecting fruits:
 * <p>
 * You are given only two baskets, each capable of holding an unlimited quantity of a single type of fruit.
 * <p>
 * You can start collecting from any tree but must collect exactly one fruit from each tree (including the starting tree) while moving to the right.
 * <p>
 * You must stop while encountering a tree with a fruit type that cannot fit into any of your baskets.
 * <p>
 * Return the maximum number of fruits you can collect following the above rules for the given array of fruits.
 * eg: fruits 3 2 1 1 2 3
 * op: 4
 */
public class FruitIntoBaskets {
    /*Solution

    The challenge is to collect as many fruits as possible from a row of trees, each producing a specific type of fruit. We only have two baskets available; each can hold exactly one type of fruit, but there is no limit to the quantity of fruit(single type) a basket can hold. This means we can only collect at most two distinct types of fruits.

    The solution uses the sliding window pattern because it helps manage the range of trees being considered. It starts from a small window and expands it as more trees are added, allowing maximum fruit collection. However, if the number of fruit types exceeds two, the window reduces its size from the left until it becomes valid again (with only two fruit types). The solution keeps sliding the window and keeping track of the largest valid window size that represents the maximum number of fruits that can be collected.

    Here’s the step-by-step explanation of the solution:

        We initialize a hash map, baskets, to track the count of each fruit type available in the current window and a variable left to mark the start of the current window.

        We also create a variable, collected, to store the number of fruits we can collect.

        We then iterate through the fruits array, starting from the leftmost tree and moving toward the end of the array. We do the following for each tree while iterating:

            Add the fruit type as a key in baskets and increment the count against it by 11.

            If the length of baskets exceeds 22, the number of distinct fruit types is more than 22 in the current window.

                We remove the fruit from the left of the current window until the window has at most 22 types of fruit.

                If the count of a fruit becomes zero:

                    We remove it from the baskets.

                Next, we increment the left by 11 to move the window forward.

            After adjusting the window, we compute the maximum number of fruits that can be collected from the current window using the formula: maximum(collected, right  -  left  +  1)maximum(collected, right  -  left  +  1). We store this value in collected.

        After iterating through fruits, we return collected, representing the maximum number of collected fruits.

    Let’s look at the following illustration to get a better understanding of the solution:*/
    public static void main(String[] args) {

    }
}
