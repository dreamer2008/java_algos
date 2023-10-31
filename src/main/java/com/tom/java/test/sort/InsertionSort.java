package com.tom.java.test.sort;

//每次将一个数字插入一个有序的数组里，成为一个长度更长的有序数组，有限次操作以后，数组整体有序。
//稳定排序，在接近有序的情况下，表现优异
public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {6, 2, 1, 3, 5, 4};
        insertSort2(a);
//        System.out.println(Arrays.toString(a));
        printTriangle(7);
        printTriangle(10);
        printMultiTable();

    }

    public static void insertSort(int[] arr) {
        // 从第二个数开始，往前插入数字
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            // 寻找插入位置的过程中，不断地将比 currentNumber 大的数字向后挪
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 两种情况会跳出循环：1. 遇到一个小于或等于 currentNumber 的数字，跳出循环，currentNumber 就坐到它后面。
            // 2. 已经走到数列头部，仍然没有遇到小于或等于 currentNumber 的数字，也会跳出循环，此时 j 等于 -1，currentNumber 就坐到数列头部。
            arr[j + 1] = temp;
        }
    }

    public static void insertSort12(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    public static void insertSort2(int[] nums) {
        int len = nums.length;
        // 循环不变量：将 nums[i] 插入到区间 [0, i) 使之成为有序数组
        for (int i = 1; i < len; i++) {
            // 先暂存这个元素，然后之前元素逐个后移，留出空位
            int temp = nums[i];
            int j = i - 1;
            // 注意边界 j > 0
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }

    public  static void printTriangle(int n) {
        for (int i = 1; i <= n /2 + n % 2 * 1; i++ ) {
            StringBuffer s = new StringBuffer();
            for (int j = 1; j <= i; j++) {
                s.append("*");
            }
            System.out.println(s.toString());
        }

        for (int i = n/2 + n % 2 * 1 + 1; i <= n; i++) {
            StringBuffer s = new StringBuffer();
            for (int j = 1; j <= n + n % 2 * 1 - i; j++) {
                s.append("*");
            }
            System.out.println(s.toString());
        }
    }

    private static  void printMultiTable() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }

}
