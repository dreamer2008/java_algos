package com.tom.java.test.leetcode;

public class Problem409 {

    public static void main(String[] args) {

        String str = "abccccdd";
        int len = longestPalindrome(str);
        System.out.println(len);
    }

    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] count = new int[128];
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            count[c]++;
        }

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
}
