package com.leetcode.dynamicprogram.medium;

import org.junit.Test;

public class Solution {

    /**
     * 5. 最长回文子串
     * https://leetcode-cn.com/problems/longest-palindromic-substring/
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String max = "";
        int start = 0, end = 0;
        int temp =1;
        for(int i=0; i<s.length(); i++){
            temp =1;
            //循环寻找回文子串，比较是否最长
            while((start= i-temp) >= 0 && (end = i+temp) < s.length() ){
                if(s.charAt(start) == s.charAt(end)){
                    String str;
                    if(  (str = s.substring(start, end+1)).length() > max.length()) max = str;
                }
                temp++;
            }
        }
        return max;
    }

    /**
     * 152. 乘积最大子数组
     * https://leetcode-cn.com/problems/maximum-product-subarray/
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int a=1;
        int max=nums[0];

        for(int num:nums){
            a=a*num;
            if(max<a)max=a;
            if(num==0)a=1;

        }
        a=1;
        for(int i=nums.length-1;i>=0;i--){
            a=a*nums[i];
            if(max<a)max=a;
            if(nums[i]==0)a=1;
        }
        return max;
    }

    @Test
    public void test() {
//        longestPalindrome("babad");
//        String s = "babad";
//        System.out.println(s.charAt(1));
//        System.out.println(s.charAt(2));
//        System.out.println(s.charAt(3));
//        System.out.println(s.charAt(3) == s.charAt(1));
        int[][] res = new int[3][2];
        res[1][0] = 1;
        res[1][1] = 1;
//        System.out.println(res.length);
//        System.out.println(res[0].length);
        System.out.println(uniquePathsWithObstacles(res));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0) {
            return 0;
        }
        if(obstacleGrid[0][0] ==1 )return 0;
        int width = obstacleGrid[0].length;
        int height =  obstacleGrid.length;
        int[][] res = new int[height][width];

        for(int i=0; i< height; i++){
            for(int j=0; j< width; j++){
                if(obstacleGrid[i][j] == 1){
                    res[i][j] = 0;
                }else{
                    if(i == 0 & j == 0){
                        res[i][j] = 1;
                    }else if(i == 0 ){
                        res[i][j] += res[0][j-1];
                    }else if( j == 0){
                        res[i][j] += res[i-1][0];
                    }else{
                        res[i][j] = res[i-1][j] + res[i][j-1];
                    }
                }
            }
        }
        return res[height-1][width-1];
    }
}
