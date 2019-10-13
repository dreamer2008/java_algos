package com.tom.java.test.leetcode;


public class MergeTwoSortedList {

    public static void main(String[] args) {

    }

    /**
     * Recursive algorithm
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode solution1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = solution1(l1.next, l2);
            return l1;
        } else {
            l2.next = solution1(l1, l2.next);
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
    public static ListNode solution2(ListNode l1, ListNode l2) {

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






