package com.leetcode.dynamicprogram;

import org.junit.Test;

public class DynamicProgram {

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j]  = Math.max(dp[j], dp[j-1]) + grid[i-1][j-1];
            }
        }
        return dp[n];

//        if( grid.length ==1 && grid[0].length ==1) return grid[0][0];
//        return dp(grid, grid.length-1, grid[0].length-1 );
    }

    public int dp(int[][] grid, int m , int n){
        if(m == 0 && n ==0){
            return grid[0][0];
        }else if(m == 0){
            return dp(grid, 0, n-1) + grid[0][n];
        }else if(n == 0){
            return dp(grid, m-1, 0) + grid[m][0];
        }
        return Math.max(dp(grid, m-1, n), dp(grid, m, n-1)) + grid[m][n];
    }

    @Test
    public void testmaxValue(){
        int[][] arr = new int[3][3];
        arr[0][0]= 1;
        arr[0][1]= 3;
        arr[0][2]= 1;

        arr[1][0]= 1;
        arr[1][1]= 5;
        arr[1][2]= 1;

        arr[2][0]= 4;
        arr[2][1]= 2;
        arr[2][2]= 1;
        System.out.println(maxValue(arr));
    }

}
