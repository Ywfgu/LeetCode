package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    static  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    /**
     * 前序遍历，递归版
     * @param root
     */
    public void preOrder(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void preOrder2(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
    }
    public void preOrder3(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                System.out.println(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                curr = node.right;
            }
        }
    }


    /**
     * 中序遍历，递归版
     * @param root
     */
    public void midOrder(TreeNode root){
        if(root != null){
            preOrder(root.left);
            System.out.println(root.val);
            preOrder(root.right);
        }
    }
    public void midOrder2(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                System.out.println(node.val);
                curr = node.right;
            }
        }
    }

    /**
     * 后序遍历，递归版
     * @param root
     */
    public void postOrder(TreeNode root){
        if(root != null){
            preOrder(root.left);
            preOrder(root.right);
            System.out.println(root.val);
        }
    }
    public void postOrder2(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        TreeNode lastVistit = null;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            if(!stack.isEmpty()){
                TreeNode treeNode = stack.peek().right;
                if(treeNode == null || treeNode == lastVistit){
                    curr = stack.pop();
                    System.out.println(curr.val);
                    lastVistit = curr;
                    curr = null;
                }else {
                    curr = treeNode;
                }
            }
        }
    }

    /**
     * 层次遍历，递归版
     * @param root
     */
    public void cellOrder(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode tn = queue.poll();
            System.out.println(tn);
            if(tn.left != null){
                queue.add(tn.left);
            }
            if(tn.right != null){
                queue.add(tn.right);
            }
        }
    }

}
