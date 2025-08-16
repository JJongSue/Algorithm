package leetcode;
/*
 * https://leetcode.com/problems/add-two-numbers/
 * LeetCode Problem 2: Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return it as a linked list.
 * The two numbers are represented by linked lists, where each node contains a single digit. The digits are stored in reverse order, meaning that the 1's digit is at the head of the list.
 * Example:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807, so the linked list representing the sum is [7,0,8].
 * Note: The input linked lists are guaranteed to be non-empty and contain only digits from 0 to 9. The output linked list should also be in reverse order.
 * This problem can be solved by iterating through both linked lists, adding the corresponding digits along with any carry from the previous addition, and creating a new linked list to store the result.
 * The time complexity of this solution is O(max(m, n)), where m and n are the lengths of the two linked lists. The space complexity is also O(max(m, n)) for the output linked list.
 * This problem is a classic example of how to handle addition with carry in linked lists, and it can be solved using a simple iterative approach.
 * This code is a placeholder for the solution to LeetCode Problem 2.
 */

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution_2 {
    public static class ListNode {
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
    public static ListNode getListNode(int[] vals) {
        ListNode head = new ListNode(vals[0]);
        ListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current.next = new ListNode(vals[i]);
            current = current.next;

        }
        return head;
    }
    public static String toString(ListNode node) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(node.val);
        while(node.next != null) {
            node = node.next;
            list.add(node.val);
        }
        return list.toString();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int nextNum = (l1.val + l2.val) / 10;
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        ListNode current = head;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            current.next = new ListNode((l1.val + l2.val + nextNum) % 10);
            nextNum = (l1.val + l2.val + nextNum) / 10;
            current = current.next;
        }
        while(l1.next != null) {
            l1 = l1.next;
            current.next = new ListNode((l1.val + nextNum) % 10);
            nextNum = (l1.val + nextNum) / 10;
            current = current.next;
        }
        while(l2.next != null) {
            l2 = l2.next;
            current.next = new ListNode((l2.val + nextNum) % 10);
            nextNum = (l2.val + nextNum) / 10;
            current = current.next;
        }
        if(nextNum > 0) {
            current.next = new ListNode(nextNum);
        }
        return head;
    }

    public static void main(String[] args) {
//        System.out.println(toString(getListNode(new int[]{2, 4, 3})));
//        System.out.println(toString(getListNode(new int[]{5, 6, 4})));
        System.out.println(toString(addTwoNumbers(
                getListNode(new int[]{2, 4, 3})
                , getListNode(new int[]{5, 6, 4})
        )));
        System.out.println(toString(addTwoNumbers(
                getListNode(new int[]{5, 6, 4})
                , getListNode(new int[]{2, 4, 3})
        )));
        System.out.println(toString(addTwoNumbers(
                getListNode(new int[]{9,9,9,9,9,9,9})
                , getListNode(new int[]{9,9,9,9})
        )));
        System.out.println(toString(addTwoNumbers(
                getListNode(new int[]{9,9,9,9})
                , getListNode(new int[]{9,9,9,9,9,9,9})
        )));
    }
}
