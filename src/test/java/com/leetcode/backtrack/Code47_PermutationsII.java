package com.leetcode.backtrack;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Code47_PermutationsII {

    @Test
    public void test() {
        permuteUnique(new int[]{1, 1, 2});
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (length == 0) return res;

        Arrays.sort(nums);

        boolean[] used = new boolean[length];

        dfs(nums, length, 0, new ArrayList(), res, used);
        return res;
    }

    private void dfs(int[] nums, int length, int deep, ArrayList path, List<List<Integer>> res, boolean[] used) {
        if (length == deep) {
            res.add(new ArrayList<>(path));
            return;
        }

        int preNum = nums[0] - 1;
        for (int i = 0; i < length; i++) {
            if (!used[i] && nums[i] != preNum) {
                preNum = nums[i];
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, length, deep + 1, path, res, used);

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }

    }


}
