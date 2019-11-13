package com.tom.java.test.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem138 {

    public static void main(String[] args) {

    }

    // Time: O(N) Space:O(N)
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val, null, null));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    //Time: O(N) Space: O(1)
    // https://blog.csdn.net/liuchonge/article/details/74858192

}


// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};