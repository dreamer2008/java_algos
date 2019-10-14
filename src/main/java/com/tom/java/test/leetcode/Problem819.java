package com.tom.java.test.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem819 {

    public static void main(String[] args) {

        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String mostCommonWord = mostCommonWord1(paragraph, banned);
        System.out.println(mostCommonWord);

    }

    public static String mostCommonWord1(String paragraph, String[] banned) {
        HashSet<String> bannedSet = new HashSet<>();
        HashMap<String, Integer> wordsMap = new HashMap<>();
        String mcw = "";
        int mcwCount = -1;

        // put banned words into hash set
        for (String s : banned) {
            bannedSet.add(s);
        }

        // process non-letter chars
        String[] wordsArr = paragraph.toLowerCase().replaceAll("[^a-zA-Z]", " ").split(" ");

        // count and add non-banned words into wordsMap
        for (String s : wordsArr) {
            if (!bannedSet.contains(s) && !s.equals("")) {
                wordsMap.put(s, wordsMap.getOrDefault(s, 0) + 1);

                int count = wordsMap.get(s);
                // update the count and the word
                if (count > mcwCount) {
                    mcw = s;
                    mcwCount = count;
                }
            }

        }

        return mcw;

    }

    public static String mostCommonWord2(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word : banned) {
            banset.add(word);
        }

        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }

}
