package com.tom.java.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15 {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(arr);
        System.out.println(list);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        if (nums == null || nums.length < 3) return ret;

        Arrays.sort(nums);

        int target = 0;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;    // skip duplicates
            }
            if(nums[i] > target) {
                break;
            }

            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++; // skip duplicates
                    while (j < k && nums[k] == nums[k + 1]) k--; // skip duplicates
                } else if (sum < target) {
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++; // skip duplicates
                } else {
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) k--; // skip duplicates
                }

            }
        }
        return ret;
    }


}
