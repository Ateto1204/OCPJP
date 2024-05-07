/**
 * https://leetcode.com/problems/double-a-number-represented-as-a-linked-list
 * Problem ID: 2816. Double a Number Represented as a Linked List
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
    public ListNode doubleIt(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int carry = 0;
        Stack<Integer> tmp = stack;
        Stack<Integer> result = new Stack<>();
        while (!tmp.isEmpty()) {
            int total = tmp.peek()*2 + carry;
            tmp.pop();
            result.push(total%10);
            carry = 0;
            if (total >= 10) carry = 1;
        }
        cur = head;
        if (carry == 1) {
            result.push(1);
        }
        while (cur != null) {
            cur.val = result.peek();
            result.pop();
            if (cur.next == null) break;
            cur = cur.next;
        }
        if (carry == 1 && cur != null) {
            ListNode node = new ListNode(result.peek(), null);
            cur.next = node;
        }
        return head;
    }
}