package com.leetcode.string;

import org.junit.Test;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 */
public class Code32_Parentheses_LongestValid {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;
        char[] str = s.toCharArray();
        //辅助数组，记录当前结尾的最大有效字串的长度
        int[] dp = new int[str.length];
        int length = 0;
        int pre = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && str[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
                length = Math.max(dp[i], length);
            }
        }
        return length;
    }

    @Test
    public void test(){
        System.out.println(longestValidParentheses("()()"));
        System.out.println(longestValidParentheses("())"));
        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
    }

}
