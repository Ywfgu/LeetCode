package com.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: [1,2,2]
 输出:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]

 * 两个子集如果只是元素的排列顺序不一样，则认为重复
 */
public class Code90_SubsetsII {
    @Test
    public void test(){
        subsetsWithDup(new int[]{1,2,2});
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<Integer>(), res, 0);
        return res;
    }

    public void dfs(int[] nums, List<Integer> path, List<List<Integer>> res, int start){
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;

            path.add(nums[i]);

            dfs(nums, path, res, i+1);

            path.remove(path.size() - 1);
        }
    }

}
