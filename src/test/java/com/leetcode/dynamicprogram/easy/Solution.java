package com.leetcode.dynamicprogram.easy;

import org.junit.Test;

public class Solution {

    /**
     * 面试题42. 连续子数组的最大和
     * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
     * https://leetcode-cn.com/problems/maximum-subarray/
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    /**
     * 392. 判断子序列
     * https://leetcode-cn.com/problems/is-subsequence/
     * 示例 1:
     * s = "abc", t = "ahbgdc"
     * <p>
     * 返回 true.
     * <p>
     * 示例 2:
     * s = "axc", t = "ahbgdc"
     * <p>
     * 返回 false.
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int slength = s.length();
        int from = 0;
        for (int i = 0; i < slength; i++) {
            int index = t.indexOf(s.charAt(i), from);
            if (index >= 0) {
                from = index + 1;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 70. 爬楼梯
     * https://leetcode-cn.com/problems/climbing-stairs/
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        //斐波那契数列 dp数组
        if (n <= 2) return n;
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    /**
     * 746. 使用最小花费爬楼梯
     * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] res = new int[cost.length];
        res[0] = cost[0];
        res[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            //定义dp[i] 为《到达》该台阶的最小花费
            res[i] = Math.min(res[i - 1], res[i - 2]) + cost[i];
        }
        return Math.min(res[cost.length - 1], res[cost.length - 2]);
    }
    public int minCostClimbingStairs2(int[] cost) {
        int f0 = cost[0];
        int f1 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            //优化空间
            int f2 = Math.min(f0, f1) + cost[i];
            f0 = f1;
            f1 = f2;
        }
        return Math.min(f0, f1);
    }

    /**
     * 198. 打家劫舍
     * https://leetcode-cn.com/problems/house-robber/
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int f0 = 0, f1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int f2 = Math.max(f0 + nums[i], f1);
            f0 = f1;
            f1 = f2;
        }
        return Math.max(f0, f1);
    }

    /**
     * 213. 打家劫舍 II
     * https://leetcode-cn.com/problems/house-robber-ii/
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if(nums.length == 1) return nums[0];
        int f0 = 0, f1 = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int f2 = Math.max(f0 + nums[i], f1);
            f0 = f1;
            f1 = f2;
        }
        int q1 = Math.max(f0, f1);
        f0 = 0; f1 = 0;
        for (int i = 1; i < nums.length; i++) {
            int f2 = Math.max(f0 + nums[i], f1);
            f0 = f1;
            f1 = f2;
        }
        int q2 = Math.max(f0, f1);

        return Math.max(q1, q2);
    }

    public int rob3(int[] nums) {
        return 0;
    }

    /**
     * 121. 买卖股票的最佳时机
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        return 0;
    }

    @Test
    public void test() {


        System.out.println("bbaaaa".indexOf("a", 2));
        isSubsequence("aaaaaa", "bbaaaa");

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

}
