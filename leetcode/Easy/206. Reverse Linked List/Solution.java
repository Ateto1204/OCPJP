/**
 * https://leetcode.com/problems/reverse-linked-list/description
 * Problem ID: 206. Reverse Linked List
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
    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList();
        ListNode dummy = head;
        while(dummy != null) {
            list.add(dummy.val);
            dummy = dummy.next;
        }
        int n = list.size();
        if(n <= 1) return head;
        dummy = head;
        for(int i = n-1; i >= 0; i--) {
            dummy.val = list.get(i);
            dummy = dummy.next;
        }
        return head;
    }
}