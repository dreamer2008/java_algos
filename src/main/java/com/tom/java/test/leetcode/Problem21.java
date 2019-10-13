package com.tom.java.test.leetcode;


public class Problem21 {

    public static void main(String[] args) {

    }

    /**
     * Recursive algorithm
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }

    }

    /**
     * Non-recusive algorithm
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);

        ListNode pre = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = (l1 == null ? l2 : l1);
        return head.next;

    }


}

class ListNode {

    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }
}






