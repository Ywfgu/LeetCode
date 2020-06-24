package com.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。

 示例:

 输入: nums = [1,2,3]
 输出:
 [
   [3],
   [1],
   [2],
   [1,2,3],
   [1,3],
   [2,3],
   [1,2],
   []
 ]

 */
public class Code78_Subsets {


    /**
     * 迭代
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int n = res.size();
            for (int j = 0; j < n; j++) {
                List<Integer> in = new ArrayList<>(res.get(j));
                in.add(nums[i]);
                res.add(in);
            }
        }
        return res;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        return null;
    }

    @Test
    public void test(){
        subsets(new int[]{1,2,3});
    }
}
