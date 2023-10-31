package com.tom.java.test.hackerrank;

public class Occurrence {

    public static void main(String[] args) {
        String s = "ababa";
        long n = 3L;
        long l = repeatedString(s, n);
        System.out.println(l);


    }

    public static long repeatedString(String s, long n) {
        // Write your code here
        long result = 0;
        int nInS = 0;
        int len = s.length();
        if (n < len) {
            String sub = s.substring(0, (int) (n));
            for (char c : sub.toCharArray()) {
                if (c == 'a') result++;
            }
            return result;
        }

        for (char c : s.toCharArray()) {
            if (c == 'a') nInS++;
        }

        long dividend = n / len;
        if (dividend == 0) return nInS * dividend;
        result += nInS * dividend;
        long remainder = n % len;
        String tailString = s.substring(0, (int) (remainder));
        for (char c: tailString.toCharArray()) {
            if (c == 'a') result++;
        }
        return result;

    }
}
