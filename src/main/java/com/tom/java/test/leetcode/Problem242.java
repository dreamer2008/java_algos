package com.tom.java.test.leetcode;

import java.util.HashMap;

public class Problem242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String str = s.charAt(i) + "";
            Integer count = map1.getOrDefault(str, 0);
            map1.put(str, count + 1);
        }
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            String str = t.charAt(i) + "";
            Integer count = map2.getOrDefault(str, 0);
            map2.put(str, count + 1);
        }
        return map1.equals(map2);
    }
}
