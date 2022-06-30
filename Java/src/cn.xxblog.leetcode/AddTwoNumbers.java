package cn.xxblog.leetcode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();

        while (l1.next != null) {
            int sum = l1.val+l2.val;
            ListNode next = new ListNode();
            head.val = sum;
            next = new ListNode();
            head.next = next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}