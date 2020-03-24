package com.questions.map;

import java.util.*;
import java.util.Map.Entry;

/**
 * Write a program to find maximum repeated words from a file
 *
 * @author Adarshs
 */
public class WordCount {

    /**
     * We will use Hashmap for this purpose.
     *
     * @Pseudo >Iterate through file For each word: if(word is as key in
     * hashmap){ increment its value } else{ add word in hashmap as key
     * and value as 1} >Sort Hashmap based on Value Fetch each entry
     * from map Add each entry into a linked list as a List<Entry> Sort
     * Linked list using collections.sort and comparator method.
     * @Analysis
     */
    public static void main(String[] args) {

        String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam dictum eu augue eget volutpat. Mauris non lorem vitae purus aliquet suscipit. Suspendisse suscipit sed ipsum sit amet lobortis. Ut risus purus, suscipit id faucibus eget, dignissim sit amet leo. Aliquam vel mattis ligula. Donec accumsan, felis quis tempor vestibulum, odio dolor congue mi, at semper velit ligula ac metus. Praesent porta tincidunt est. Nunc orci odio, iaculis eu lorem quis, efficitur viverra lectus. Vestibulum laoreet faucibus mauris id gravida. Praesent venenatis sollicitudin fringilla.Aliquam auctor, justo at ornare semper, quam ex ultrices ex, sed pellentesque justo ante eleifend odio. Duis sed lacinia turpis. Aenean sem nulla, ornare et ullamcorper vitae, mollis sit amet arcu. Vestibulum ac felis tincidunt, venenatis est a, posuere leo. Maecenas elementum sem in dui interdum, nec luctus est varius. Suspendisse felis quam, luctus sed orci id, fringilla pretium tortor. Suspendisse rutrum auctor eros eu tempus. Curabitur sit amet malesuada dui, vel facilisis purus. Nulla mollis velit lacinia magna pretium, vitae vestibulum mauris vehicula.Ut consequat tortor eu efficitur molestie. Nulla quis purus et nisl molestie tincidunt a in libero. Pellentesque lobortis lobortis eros efficitur maximus. Morbi in tortor eu neque dictum placerat. Integer erat purus, mollis eu leo sed, suscipit condimentum sapien. Suspendisse ut lacinia ante. Nam commodo dui vel tincidunt vulputate.Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec in egestas elit. Pellentesque fermentum feugiat fringilla. Etiam viverra facilisis elit, iaculis luctus tortor consectetur in. Sed eget dui dictum, porta tortor quis, dignissim orci. Nunc facilisis, leo sit amet blandit pulvinar, felis felis interdum turpis, eu consectetur quam elit a mauris. Morbi in quam luctus nunc condimentum congue.Cras ultrices est pulvinar, vehicula est vitae, porta libero. Nam eget eleifend risus. Aliquam erat volutpat. Quisque tellus risus, volutpat id quam at, lacinia ultrices sapien. Vivamus in tortor lorem. Ut et purus eu massa lacinia molestie eget eu orci. Curabitur elit lectus, molestie at ullamcorper sed, ullamcorper et ligula. Etiam tristique urna ipsum, ac vulputate nisi auctor eu. Nam mi odio, aliquet id aliquet nec, volutpat vel elit. Vestibulum at urna mollis, tincidunt est vel, finibus ex. Proin nibh justo, interdum non tincidunt et, pretium quis ante. ";
        Map<String, Integer> wordCount = new HashMap<>();

        String[] inputArr = input.split(" ");
        for (String a : inputArr) {
            if (wordCount.containsKey(a)) {
                wordCount.put(a, wordCount.get(a) + 1);
            } else {
                wordCount.put(a, 1);
            }
        }

        sortByValue(wordCount);

    }

    private static void sortByValue(Map<String, Integer> wordCount) {
        Set<Entry<String, Integer>> set = wordCount.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<>(set);

        Collections.sort(list, new Comparator<Entry<String, Integer>>() {

            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {

                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String, Integer> output : list) {
            System.out.println(output.getKey() + ": count->" + output.getValue());
        }
    }
}
