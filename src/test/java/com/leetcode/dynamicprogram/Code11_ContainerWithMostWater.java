package com.leetcode.dynamicprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。

 示例：

 输入：[1,8,6,2,5,4,8,3,7]
 输出：49

 输入：[1,0,1]
 输出：1

 */
public class Code11_ContainerWithMostWater {

//    public int maxArea(int[] height) {
//        int length = height.length;
//        int[] dp = new int[length];
//        int left = 0;
//        int right = length-1;
//
//        int index = left;
//        for (int i = 0; i < length; i++) {
//            if(height[index] < height[left] && height[index] < height[right]){
//                dp[index] = Math.min(height[left], height[right]) - height[index];
//            }
//        }
//
//        return 0;
//    }

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("a",1);
        treeMap.put("c",2);
        treeMap.put("b",3);
        System.out.println(1);
    }
}
