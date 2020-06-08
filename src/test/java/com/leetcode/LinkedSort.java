package com.leetcode;

import org.junit.Test;

public class LinkedSort {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode first = new ListNode(-1);
        ListNode last = first;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                last.next = l1;
                l1 = l1.next;
            }else{
                last.next = l2;
                l2 = l2.next;
            }
            last = last.next;
        }
        last.next = (l1 == null)?l2:l1;

        return first.next;
    }
    @Test
    public void testmergeTwoLists(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);

//        l1.next = l2;
//        l2.next = l3;
//
//        l4.next = l5;
//        l5.next = l6;

//        ListNode node = mergeTwoLists(new ListNode(2),new ListNode(1));
        ListNode node = l1;
        node.next = l2;
        System.out.println(node);
    }


    @Test
    public void testreverseWords(){
        String s ="Let's take LeetCode contest";

        StringBuilder sb = new StringBuilder();
        String[] s1 = s.split(" ");

        for (String str: s1) {

            int start = 0;
            int end = str.length()-1;
            while (end >= start){
                sb.append(str.charAt(end));
                end --;
            }
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());


    }

    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return null;

        ListNode curNode = head;

        while(curNode.next != null){
            if(curNode.next.val < x){
                ListNode tmp = curNode.next;
                curNode.next = curNode.next.next;
                tmp.next = head;
                head = tmp;
            }
            else
                curNode = curNode.next;
        }

        return head;
    }

    @Test
    public void testpartition(){

        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(10);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        partition(l1, 3);
    }

    @Test
    public void test(){
        int a;
        int A=1;
        a = A==1 ? 1:2;
        System.out.println( );
    }
}
