package com.leetcode.linked;

import org.junit.Test;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class Code160_TwoLinked_Intersection {

    /**
     * 方法
     * A
     * B
     *
     * A+B
     * B+A
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode currA = headA;
        ListNode currB = headB;
        while(currA != currB){

            currA = currA != null ? currA.next : headB;
            currB = currB != null ? currB.next : headA;

        }
        return currA;
    }

    @Test
    public void test(){

    }
}
