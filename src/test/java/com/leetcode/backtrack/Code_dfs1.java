package com.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯
 *
 * 1
 * 1,2
 * 1,2,3
 * 1,3
 * 2
 * 2,3
 * 3
 */
public class Code_dfs1 {

    @Test
    public void test(){
        dfsEnter(new int[]{1,2,3});
    }

    public List<List<Integer>> dfsEnter(int[] nums){
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, new ArrayList<Integer>(), 0, res);
        return res;
    }

    private void dfs(int[] nums, ArrayList<Integer> list, int start, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);

            dfs(nums, list, i+1, res);

            list.remove(list.size()-1);
        }
    }

}
