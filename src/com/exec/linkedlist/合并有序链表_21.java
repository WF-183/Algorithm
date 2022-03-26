package com.exec.linkedlist;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/3/2
 * @version: 1.0.0
 */
public class 合并有序链表_21 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode listNode = new 合并有序链表_21().mergeTwoLists(list1, list2);
        System.out.println(listNode);

    }



    // 简单，典型双指针
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 辅助头结点
        ListNode newHead = new ListNode();

        ListNode temp = newHead;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        }
        if (temp2 != null) {
            temp.next = temp2;
        }
        return newHead.next;
    }
}
