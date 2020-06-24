package com.leetcode.backtrack;

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

    /**
     * 回溯
     */
    List<List<Integer>> output = new ArrayList();
    int n, k;
    public List<List<Integer>> subsets2(int[] nums) {
        n = nums.length;
        for (k = 0; k < n+1; k++) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        if(curr.size() == k) output.add(new ArrayList<>(curr));

        for (int i = first; i < n; i++) {
            curr.add(nums[i]);

            backtrack(i+1, curr, nums);

            curr.remove(curr.size() - 1);
        }
    }

    /**
     * 回溯  dfs
     */
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets3(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        for(int i = 0; i < nums.length; i ++) {
            dfs(nums, i, new ArrayList<>());
        }
        res.add(new ArrayList<>());
        return res;
    }
    private void dfs(int[] nums, int index, List<Integer> list) {
        list.add(nums[index]);
        index ++;
        for(; index < nums.length; index ++) {
            dfs(nums, index, new ArrayList<>(list));
        }
        res.add(list);
    }

    @Test
    public void test(){
        subsets(new int[]{1,2,3});
        subsets2(new int[]{1,2,3});
        subsets3(new int[]{1,2,2});
    }


}
