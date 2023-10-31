package com.tom.java.test.sort;

import java.util.Arrays;

/**
 * 计数排序的基本思想是：对每一个输入的元素arr[i]，确定小于 arr[i] 的元素个数
 * 只适用于数据范围不大的场景
 */
public class CountSort {

    public static void main(String[] args) {
        int[] a = {106, 102, 101, 103, 105, 102};
//        System.out.println(Arrays.toString(countSort1(a)));
//        System.out.println(Arrays.toString(countSort2(a)));
        countSort3(a);
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
    }

    public static int[] countSort1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找出数组中的最大最小值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int help[] = new int[max];

        //找出每个数字出现的次数
        for (int i = 0; i < arr.length; i++) {
            int mapPos = arr[i] - min;
            help[mapPos]++;
        }

        int index = 0;
        for (int i = 0; i < help.length; i++) {
            while (help[i]-- > 0) {
                arr[index++] = i + min;
            }
        }

        return arr;
    }

    public static int[] countSort2(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找出数组中的最大最小值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int[] help = new int[max - min + 1];

        //找出每个数字出现的次数
        for (int i = 0; i < arr.length; i++) {
            int mapPos = arr[i] - min;
            help[mapPos]++;
        }

        //计算每个数字应该在排序后数组中应该处于的位置
        for (int i = 1; i < help.length; i++) {
            help[i] = help[i - 1] + help[i];
        }

        //根据help数组进行排序
        int res[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int post = --help[arr[i] - min];
            res[post] = arr[i];
        }

        return res;
    }

    public static void countSort3(int[] arr) {
        // 防止数组越界
        if (arr == null || arr.length <= 1) return;
        // 找到最大值，最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            else if (arr[i] < min) min = arr[i];
        }
        // 确定计数范围
        int range = max - min + 1;
        // 建立长度为 range 的数组，下标 0~range-1 对应数字 min~max
        int[] counting = new int[range];
        // 遍历 arr 中的每个元素
        for (int element : arr) {
            // 将每个整数出现的次数统计到计数数组中对应下标的位置，这里需要将每个元素减去 min，才能映射到 0～range-1 范围内
            counting[element - min]++;
        }
        // 每个元素在结果数组中的最后一个下标位置 = 前面比自己小的数字的总数 + 自己的数量 - 1。我们将 counting[0] 先减去 1，后续 counting 直接累加即可
        counting[0]--;
        for (int i = 1; i < range; i++) {
            // 将 counting 计算成当前数字在结果中的最后一个下标位置。位置 = 前面比自己小的数字的总数 + 自己的数量 - 1
            // 由于 counting[0] 已经减了 1，所以后续的减 1 可以省略。
            counting[i] += counting[i - 1];
        }
        int[] result = new int[arr.length];
        // 从后往前遍历数组，通过 counting 中记录的下标位置，将 arr 中的元素放到 result 数组中
        for (int i = arr.length - 1; i >= 0; i--) {
            // counting[arr[i] - min] 表示此元素在结果数组中的下标
            int pos = counting[arr[i] - min]--;
            result[pos] = arr[i];
            // 更新 counting[arr[i] - min]，指向此元素的前一个下标
//            counting[arr[i] - min]--;
        }
        // 将结果赋值回 arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }

}
