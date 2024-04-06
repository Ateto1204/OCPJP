/*
 *
 * https://leetcode.com/problems/add-two-numbers
 * Problem ID: 2. Add Two Numbers
 * 
 * Author: Ateto
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;
        byte carry = 0;
        while (l1 != null || l2 != null) {
            int tmp = 0;
            if (l1 != null) {
                tmp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                tmp += l2.val;
                l2 = l2.next;
            }
            tmp += carry;
            carry = 0;
            if (tmp >= 10) {
                carry = 1;
                tmp -= 10;
            }
            ListNode node = new ListNode(tmp);
            current.next = node;
            current = current.next;
        }
        if (carry == 1) {
            ListNode node = new ListNode(1);
            current.next = node;
        }
        return result.next;
    }
}