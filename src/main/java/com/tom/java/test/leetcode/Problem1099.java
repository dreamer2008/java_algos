package com.tom.java.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1099 {

    public static void main(String[] args) {
        int[] arr = {34, 23, 1, 24, 75, 33, 54, 8};
        int K = 60;
        int maxSum = twoSumLessThanK(arr, K);
        System.out.println(maxSum);
    }

    public static int twoSumLessThanK(int[] A, int K) {

        if (A == null || A.length < 2) return -1;

        Arrays.sort(A);

        int len = A.length;
        int i = 0;
        int j = len - 1;
        int res = -1;
        while (i < j) {
            int sum = A[i] + A[j];
            if (sum < K) {
                res = Math.max(res, sum);
                i++;
            } else {
                j--;
            }
        }
        return res;
    }


}
