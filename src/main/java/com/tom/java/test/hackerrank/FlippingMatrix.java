package com.tom.java.test.hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * e.g.
 * [
 * [112,42,83,119],
 * [56,125,56,49],
 * [15,78,101,43],
 * [62,98,114,108]
 * ]
 */
public class FlippingMatrix {

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(List.of(112, 42, 83, 119));
        matrix.add(List.of(56, 125, 56, 49));
        matrix.add(List.of(15, 78, 101, 43));
        matrix.add(List.of(62, 98, 114, 108));
//        System.out.println(matrix);
//        int maxTotal1 = flippingMatrix(matrix);
//        int maxTotal2 = flippingMatrix2(matrix);
        String s = "seaside the to sent be to ne2ds army ten of team a";
        System.out.println(decryptMessage(s));
        Float f = Float.parseFloat("3.0");
        int i = f.intValue();
        byte b = f.byteValue();
        double d = f.doubleValue();
//        System.out.println(i+b+d);
        System.out.println(caesarCipher("middle-Outz",2));
        System.out.println(caesarCipher("159357lcfd",98));
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int result = 0;
        int max = 0;
        int n = matrix.size() / 2;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                max = Integer.MIN_VALUE;
                int num1 = matrix.get(row).get(col);
                int num2 = matrix.get(row).get(2 * n - col - 1);
                int num3 = matrix.get(2 * n - row - 1).get(col);
                int num4 = matrix.get(2 * n - row - 1).get(2 * n - col - 1);
                max = Math.max(Math.max(Math.max(Math.max(num1, max), num2), num3), num4);
                result += max;
            }
        }
        return result;
    }

    public static int flippingMatrix2(List<List<Integer>> matrix) {
        int result = 0;
        int max = 0;
        int n = matrix.size() / 2;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                max = Integer.MIN_VALUE;
                max = Math.max(matrix.get(row).get(col), max);
                max = Math.max(matrix.get(row).get(2 * n - col - 1), max);
                max = Math.max(matrix.get(2 * n - row - 1).get(col), max);
                max = Math.max(matrix.get(2 * n - row - 1).get(2 * n - col - 1), max);
                result += max;
            }
        }
        return result;
    }

    public static String decryptMessage(String encryptedMessage) {
        String[] strs = encryptedMessage.split(" ");
        String result = "";
        for (int i = strs.length - 1; i >= 0; i--) {
            String s = strs[i];
            char[] chars = s.toCharArray();
            String temp = "";

            for (int j = 0; j < chars.length - 1; j++) {
                char cur = chars[j];
                char next = chars[j+1];
                if (Character.isLetter(cur) && Character.isDigit(next)) {
                    for (int m = 1; m <= Integer.parseInt(String.valueOf(next)); m++) {
                        temp += cur;
                    }
                } else if (Character.isLetter(cur) && !Character.isDigit(next)) {
                    temp += cur;
                }
            }
            if (Character.isLetter(chars[chars.length - 1])) {
                temp += chars[chars.length - 1];
            }

            result += (temp + " ");
        }
        return result.trim();
    }


    public static String caesarCipher(String s, int k) {
        // Write your code here
        String result = "";
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetter(ch)) {
                result += ch;
            } else {
                int temp = ch + k % 26;
                int diff1 = temp - 'z';
                int diff2 = temp - 'Z';
                if (Character.isLowerCase(ch) && diff1 > 0) {
                    temp = 'a' + (diff1 - 1);
                } else if (Character.isUpperCase(ch) && diff2 > 0) {
                    temp = 'A' + (diff2 - 1);
                }
                result += (char) temp;
            }
        }
        return result;
    }

    public int firstMissingPositive(int[] A) {
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (A[i] <= len && A[i] >= 1 && A[i] != A[A[i] - 1]) {
                // System.out.println(i);
                swap(A, A[i] - 1, i);
                i--;
            }
        }
        for (int i = 0; i < len; i++) {
            if (A[i] != i + 1) return i + 1;
        }
        return len + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
