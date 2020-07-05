package com.leetcode.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Code99_RecoverBST {
    public int numTrees(int n) {
        return f(n);
    }
    public int f(int n){
        if(n == 1 || n == 0) return 1;
        if(n == 2) return 2;
        if(n == 3) return 5;

        int res = 0;

        for(int i = n-1; i >= 0; i--){
            res += (f(i) * f(n - 1 -i));
            System.out.println("i="+i+" oi:"+(n-1-i)+" "+res);
        }

        return res;
    }

    @Test
    public void Test(){
        numTrees(6);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(5);
        findSwapNum(list);
    }

    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList();

    }
    public void inorder(TreeNode root, List list){
        if(null != root){
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }

    public int[] findSwapNum(List<Integer> list){

        int x = -1, y = -1;
        for(int i = 0; i < list.size() -1; i++){
            if(list.get(i) > list.get(i+1) && x == -1) {
                x = list.get(i);
            }else if( i > 1 && list.get(i) < list.get(i-1)){
                y = list.get(i);
            }
        }
        return new int[]{x, y};
    }

    public int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for(int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                // first swap occurence
                if (x == -1) x = nums.get(i);
                    // second swap occurence
                else break;
            }
        }
        return new int[]{x, y};
    }



}
