package com.leetcode.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */
public class Code108_ConvertSortedArrayToBST {

    @Test
    public void test(){
        List<TreeNode> list = new ArrayList();
        int[] nums = {-10,-3,0,5,9};
        sortedArrayToBST(nums);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return buildTree(nums, 0, nums.length-1);
    }
    public TreeNode buildTree(int[] nums, int left, int right){
//        if(right - left <= 2){
//            if( right - left == 0){
//                return new TreeNode(nums[left]);
//            }else if(right - left == 1){
//                TreeNode rt = new TreeNode(nums[left + 1]);
//                TreeNode l = new TreeNode(nums[left]);
//                rt.left = l;
//                return rt;
//            }else if(right - left == 2){
//                TreeNode rt = new TreeNode(nums[left + 1]);
//                TreeNode l = new TreeNode(nums[left]);
//                TreeNode r = new TreeNode(nums[right]);
//                rt.left = l;
//                rt.right = r;
//                return rt;
//            }
//            return null;
//        }
        if( left > right ) return null;
        int mid = left + ((right - left) >> 1);

        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }

}
