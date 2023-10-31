package com.tom.java.test.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {6, 2, 1, 3, 5, 4};
//        bubbleSort3(a);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 如果左边的数大于右边的数，则交换，保证右边的数字最大
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSort2(int[] arr) {
        // 初始时 swapped 为 true，否则排序过程无法启动
        boolean swapped = true;
        for (int i = 0; i < arr.length - 1; i++) {
            // 如果没有发生过交换，说明剩余部分已经有序，排序完成
            if (!swapped) break;
            // 设置 swapped 为 false，如果发生交换，则将其置为 true
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 如果左边的数大于右边的数，则交换，保证右边的数字最大
                    swap(arr, j, j + 1);
                    // 表示发生了交换
                    swapped = true;
                }
            }
        }
    }

    public static void bubbleSort3(int[] arr) {
        boolean swapped = true;
        // 最后一个没有经过排序的元素的下标
        int indexOfLastUnsortedElement = arr.length - 1;
        // 上次发生交换的位置
        int swappedIndex = -1;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < indexOfLastUnsortedElement; i++) {
                if (arr[i] > arr[i + 1]) {
                    // 如果左边的数大于右边的数，则交换，保证右边的数字最大
                    swap(arr, i, i + 1);
                    // 表示发生了交换
                    swapped = true;
                    // 更新交换的位置
                    swappedIndex = i;
                }
            }
            // 最后一个没有经过排序的元素的下标就是最后一次发生交换的位置
            indexOfLastUnsortedElement = swappedIndex;
        }
    }


    // 交换元素
    private static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

    }



}
