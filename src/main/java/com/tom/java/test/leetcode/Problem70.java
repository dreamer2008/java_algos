package com.tom.java.test.leetcode;

public class Problem70 {

    public static void main(String[] args) {
        int n = 4;
        int result = climbStairs(n);
        System.out.println(result);
    }

    public static int climbStairs(int n) {
        if (n < 1)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int sum = 0, sum1, sum2;
        sum1 = 1;
        sum2 = 2;
        for (int i = 2; i < n; i++) {
            sum = sum1 + sum2;
            sum1 = sum2;
            sum2 = sum;
        }
        return sum;
    }
}
