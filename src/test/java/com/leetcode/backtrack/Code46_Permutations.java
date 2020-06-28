package com.leetcode.backtrack;

import com.leetcode.linked.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Code46_Permutations {

    @Test
    public void test() {
        permute(new int[]{1, 2, 3});
        permute2(new int[]{1, 1, 2});

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, ArrayList list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);

                dfs(nums, list, res);

                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (length == 0) return res;

        Arrays.sort(nums);

        boolean[] used = new boolean[length];

        dfs(nums, length, 0, new ArrayList<>(), res, used);

        return res;
    }

    private void dfs(int[] nums, int length, int deep, List<Integer> path, List<List<Integer>> res, boolean[] used) {
        if (deep == length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, length, deep + 1, path, res, used);

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

}
