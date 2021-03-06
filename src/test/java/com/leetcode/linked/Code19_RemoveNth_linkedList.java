package com.leetcode.linked;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：

 给定的 n 保证是有效的。

 进阶：

 你能尝试使用一趟扫描实现吗？

 */
public class Code19_RemoveNth_linkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode H = new ListNode(-1);
        H.next = head;
        ListNode slow = H;
        ListNode fast = H;

        while (n > 0){
            fast = fast.next;
            n--;
        }

        fast = fast.next;
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return H.next;
    }

}
