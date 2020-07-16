package com;


import java.util.Base64;

public class Test {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        int max = 0;
        for(int i = 1; i < n; i++){
            int payday = 1;

            while(i - payday >= 0 && prices[i] - prices[i - payday] > 0){
                int pre = i - payday - 2;
                if(pre > 0){

                    while(pre > 0){
                        dp[i] = Math.max(prices[i] - prices[i - payday] + dp[pre] , dp[i]);
                        pre --;
                    }

                }else {
                    dp[i] = Math.max(prices[i] - prices[i - payday], dp[i]);
                }
                max = Math.max(dp[i], max);
                payday ++;
            }
        }
        for(int a : dp){
            System.out.println(a);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] p = new int[]{2,5,5,2,1,7,9,6,4};
        System.out.println(maxProfit(p));

        Base64.Encoder encoder = Base64.getEncoder();
        System.out.println(new String(encoder.encode("Guht1993WxMm".getBytes())));


    }
}
