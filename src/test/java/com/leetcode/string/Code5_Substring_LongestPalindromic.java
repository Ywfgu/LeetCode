package com.leetcode.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Code5_Substring_LongestPalindromic {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] str = s.toCharArray();
        int length = str.length;
        String s1 = "", s2 = "";
        //奇数 abc
        for (int i = 1; i < length; i++) {
            int ksl = 1;
            while (i - ksl >= 0 && i + ksl < length && str[i - ksl] == str[i + ksl]) {
                ksl++;
            }
            String substring = s.substring(i - ksl + 1, i + ksl);
            s1 = s1.length() > substring.length() ? s1 : substring;
        }

        //偶数
        for (int i = 1; i < length; i++) {
            if (str[i] == str[i - 1]) {
                int ksl = 1;
                while (i - ksl - 1 >= 0 && i + ksl < length && str[i - ksl - 1] == str[i + ksl]) {
                    ksl++;
                }
                String substring = s.substring(i - ksl, i + ksl);
                s2 = s2.length() > substring.length() ? s2 : substring;
            }
        }
        return s1.length() > s2.length() ? s1 : s2;
    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

}
