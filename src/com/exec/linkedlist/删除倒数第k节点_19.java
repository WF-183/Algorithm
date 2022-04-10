package com.exec.linkedlist;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/4/2
 * @version: 1.0.0
 */
public class 删除倒数第k节点_19 {


    //输入：head = [1,2,3,4,5], n = 2 输出：[1,2,3,5]

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode res2 = removeNthFromEnd(node1, 2);
        ListNode res8 = removeNthFromEnd(node1, 8);
        System.out.println(res2);
        System.out.println(res8);
    }



    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 借助辅助头结点
        ListNode newHead = new ListNode();
        newHead.next = head;

        //双指针法
        ListNode fast = newHead;
        ListNode slow = newHead;
        //先让fast走n步，然后两个一起走，fast走到尾元素时，slow就指向待删除节点前一节点
        for(int i = 0;i < n ;i++){
            //优化-处理边界 输入值大于总长度
            if (fast == null){
                return newHead.next;
            }
            fast = fast.next;
        }
        //优化-处理边界 输入值大于总长度
        if (fast == null){
            return newHead.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // 删除操作一句话
        slow.next = slow.next.next;
        return newHead.next;
    }

}
