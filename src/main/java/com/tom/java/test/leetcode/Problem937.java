package com.tom.java.test.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Problem937 {

    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String s, String s2) {
                String[] arr = s.split(" ");
                String[] arr2 = s2.split(" ");
                boolean isDigit = Character.isDigit(arr[1].charAt(0));
                boolean isDigit2 = Character.isDigit(arr2[1].charAt(0));
                // 都是字母
                if (!isDigit && !isDigit2) {
                    int temp = s.substring(s.indexOf(' ') + 1).compareTo(s2.substring(s2.indexOf(' ') + 1));
                    if (temp != 0) {
                        return temp;
                    }
                    return arr[0].compareTo(arr2[0]);
                }
                return isDigit ? (isDigit2 ? 0 : 1) : -1;
            }
        };
        Arrays.sort(logs, com);
        return logs;

    }
}
