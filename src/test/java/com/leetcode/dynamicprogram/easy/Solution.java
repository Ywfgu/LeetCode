package com.leetcode.dynamicprogram.easy;

public class Solution {

    /**
     * 面试题42. 连续子数组的最大和
     * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i-1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
