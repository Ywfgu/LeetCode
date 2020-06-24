package com.leetcode.tree;

import java.util.Stack;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class Code101_Tree_Symmetric {

    // 迭代
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> left = new Stack();
        Stack<TreeNode> right = new Stack();

        left.push(root.left);
        right.push(root.right);

        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode ln = left.pop();
            TreeNode rn = right.pop();

            if (ln == null && rn == null) continue;
            if (ln == null || rn == null || ln.val != rn.val) return false;

            left.push(ln.left);
            left.push(ln.right);
            right.push(rn.right);
            right.push(rn.left);
        }
        return true;

    }

//    // 递归
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        return isSymm(root.left, root.right);
//    }
//
//    public boolean isSymm(TreeNode l, TreeNode r) {
//        if (l == null || r == null) return l == r;
//
//        return l.val == r.val && isSymm(l.left, r.right) && isSymm(l.right, r.left);
//    }
}
