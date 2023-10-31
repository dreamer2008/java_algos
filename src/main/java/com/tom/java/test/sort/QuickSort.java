package com.tom.java.test.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = {6, 2, 1, 3, 5, 4};
        long begin = System.currentTimeMillis();
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        System.out.println((System.currentTimeMillis() - begin));

        begin = System.currentTimeMillis();
        quickSort2(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        System.out.println((System.currentTimeMillis() - begin));
    }

    private static void quickSort(int[] arr, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作（以 arr[l] 作为基准数）
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            if (i != j) {
                swap(arr, i, j);
            }
        }
        swap(arr, i, l);
        // 递归左（右）子数组执行哨兵划分
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }


    public static void quickSort2(int[] arr, int start, int end) {
        // 如果区域内的数字少于 2 个，退出递归
        if (start >= end) return;
        // 将数组分区，并获得中间值的下标
        int middle = partition22(arr, start, end);
        // 对左边区域快速排序
        quickSort2(arr, start, middle - 1);
        // 对右边区域快速排序
        quickSort2(arr, middle + 1, end);
    }

    // 将 arr 从 start 到 end 分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标
    public static int partition22(int[] arr, int start, int end) {
        // 取第一个数为基数
        int pivot = arr[start];
        // 从第二个数开始分区
        int left = start + 1;
        // 右边界
        int right = end;
        // left、right 相遇时退出循环
        while (left < right) {
            // 找到第一个大于基数的位置
            while (left < right && arr[left] <= pivot) left++;
            // 交换这两个数，使得左边分区都小于或等于基数，右边分区大于或等于基数
            if (left != right) {
                swap(arr, left, right);
                right--;
            }
        }
        // 如果 left 和 right 相等，单独比较 arr[right] 和 pivot
        if (left == right && arr[right] > pivot) right--;
        // 将基数和中间数交换
        if (right != start) swap(arr, start, right);
        // 返回中间值的下标
        return right;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

