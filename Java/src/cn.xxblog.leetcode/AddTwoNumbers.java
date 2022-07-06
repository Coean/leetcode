package cn.xxblog.leetcode;

import java.util.Optional;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        boolean flag = false;
        while (l1 != null || l2 != null) {
            if (cur.next != null) cur = cur.next;
            int v1 = 0, v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2;
            if (flag) {
                sum++;
                flag = false;
            }
            if (sum >= 10) {
                flag = true;
                sum -= 10;
            }
            cur.val = sum;
            cur.next = new ListNode();
        }

        if (flag) {
            cur = cur.next;
            cur.val = 1;
        } else {
            cur.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(9, null);
        ListNode node2 = new ListNode(9, node3);
        ListNode node1 = new ListNode(9, node2);

        ListNode node15 = new ListNode(9, null);
        ListNode node14 = new ListNode(9, node15);
        ListNode node13 = new ListNode(9, node14);
        ListNode node12 = new ListNode(9, node13);
        ListNode node11 = new ListNode(9, node12);
//100998 108
        ListNode node = new AddTwoNumbers().addTwoNumbers(node1, node11);
        System.out.println();

    }
}



class ListNode {
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