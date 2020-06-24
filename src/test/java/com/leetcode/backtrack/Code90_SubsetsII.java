package com.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
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
