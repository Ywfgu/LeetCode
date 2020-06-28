package com.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。

 示例: 

 输入: s = 7, nums = [2,3,1,2,4,3]
 输出: 2
 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 进阶:

 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。

 */
public class Code209_MinimumSizeSubarraySum {

    @Test
    public void test(){
        int[] arr = {1,2,3,4,5};
        minSubArrayLen(11, arr);
        minSubArrayLen2(11, arr);
    }

    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, sum = 0, length =0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s){
                length = length == 0 ? i - left : Math.min(length, i - left);
                sum -= nums[left];
                left++;
            }
        }
        return length;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int length = 0;
        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, new ArrayList<>(),0, list);

        for (int i = 0; i < list.size(); i++) {
            List<Integer> l1 = list.get(i);
            int sum = l1.stream().mapToInt(e -> e).sum();
            int count = (int)l1.stream().count();

            if(sum >= s)
                length = length == 0 ? count : Math.min(length, count);
        }
        return length;
    }

    private void dfs(int[] nums, ArrayList list, int index, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);

            dfs(nums, list, i+1, res);

            list.remove(list.size()-1);
        }

    }

}
