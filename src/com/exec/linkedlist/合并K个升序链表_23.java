package com.exec.linkedlist;

import com.exec.linkedlist.ListNode;

import java.util.PriorityQueue;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/4/19
 * @version: 1.0.0
 */
public class 合并K个升序链表_23 {

    public static void main(String[] args) {
        //输入：lists = [[1,4,5],[1,3,4],[2,6]]
        //输出：[1,1,2,3,4,4,5,6]
        //ListNode[] arr = new ListNode[3];
        //ListNode listNode11 = new ListNode(1);
        //ListNode listNode14 = new ListNode(4);
        //ListNode listNode15 = new ListNode(5);
        //listNode11.next = listNode14;
        //listNode14.next = listNode15;
        //
        //ListNode listNode21 = new ListNode(1);
        //ListNode listNode23 = new ListNode(3);
        //ListNode listNode24 = new ListNode(4);
        //listNode21.next = listNode23;
        //listNode23.next = listNode24;
        //
        //ListNode listNode32 = new ListNode(2);
        //ListNode listNode36 = new ListNode(6);
        //listNode32.next = listNode36;
        //
        //arr[0] = listNode11;
        //arr[1] = listNode21;
        //arr[2] = listNode32;

        //[[-2,-1,-1,-1],[]]
        ListNode[] arr = new ListNode[2];
        ListNode listNode1 = new ListNode(-2);
        ListNode listNode2 = new ListNode(-1);
        ListNode listNode3 = new ListNode(-1);
        ListNode listNode4 = new ListNode(-1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        arr[0] = listNode1;
        arr[1] = null;

        ListNode listNode = mergeKLists(arr);
        System.out.println(listNode);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        // 技能点 借助优先队列，先全部放入，再全部取出，实现混合排序效果。技能点 优先队列可以用来做排序。
        // 其实合并两个有序链表也能这么写，不用双指针也行，还更简单了
        //先全部放进去
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }

        //再全部取出来，拼成一条新链表即可
        ListNode newHead = new ListNode();
        ListNode temp = newHead;
        while (queue.size() != 0) {
            ListNode node = queue.poll();
            //坑 每个节点本身是连着一条后续链的，这里必须把每个节点处理成独立单节点
            node.next = null;
            temp.next = node;
            temp = temp.next;
        }
        return newHead.next;
    }

}
