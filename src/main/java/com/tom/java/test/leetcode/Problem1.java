package com.tom.java.test.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum. https://leetcode.com/problems/two-sum/
 * There are at least two approaches.
 * <p>
 * #1, using hashmap as extra space, trading space for speed
 * <p>
 * #2, using two pointers after sorting the array
 */
public class Problem1 {

    public static void main(String[] args) {

        int[] arr = {3, 5, 7, 2, 1, 6};
//    int[] arr = {3,5,2,1,6};
        int target = 12;
        int[] a = twoSum1(arr, target);
        for (int item : a) {
            System.out.println(item);
        }

    }


    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (m.containsKey(target - nums[i]) && m.get(target - nums[i]) != i) {
                res[0] = i;
                res[1] = m.get(target - nums[i]);
                break;
            }
            m.put(nums[i], i);
        }
        return res;
    }

    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum4(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int[] res = new int[2];
        while (i < j) {
            if (nums[i] + nums[j] == target) {
//                res = new int[] {i,j};
                res[0] = i;
                res[1] = j;
                break;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
}
