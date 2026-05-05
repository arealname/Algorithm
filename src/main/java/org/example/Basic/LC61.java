package org.example.Basic;

public class LC61 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 计算链表长度
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 连接尾部到头部形成环
        tail.next = head;

        // 计算新的尾节点位置
        k = k % length;
        int stepsToNewTail = length - k;

        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // 新的头节点是新尾节点的下一个节点
        ListNode newHead = newTail.next;

        // 断开环
        newTail.next = null;

        return newHead;

    }
}
