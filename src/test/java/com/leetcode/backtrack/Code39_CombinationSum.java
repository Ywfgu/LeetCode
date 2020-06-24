package com.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Code39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, new ArrayList<Integer>(), res, 0, target);
        return res;
    }

    private void dfs(int[] candidates, ArrayList<Integer> list, List<List<Integer>> res, int index, int target) {
    }

    @Test
    public void test(){
        combinationSum(new int[]{1,2,3}, 5);
    }
}
