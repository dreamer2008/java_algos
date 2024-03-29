package com.tom.java.test.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 桶排序的基本思想是：把数组 arr 划分为n个大小相同子区间（桶），每个子区间各自排序，最后合并
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] a = {6, 2, 1, 3, 5, 4};
        bucketSort(a);
//        System.out.println(Arrays.toString(a));
    }

    public static void bucketSort(int[] arr) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }

        System.out.println(bucketArr.toString());

    }

}
