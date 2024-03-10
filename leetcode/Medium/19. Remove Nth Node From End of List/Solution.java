/**
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Problem ID: 19. Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        int size = 0;
        while(tmp != null) {
            tmp = tmp.next;
            size++;
        }
        if(size - n == 0) return head.next;
        tmp = head;
        for(int i=0; i < size-n-1; i++) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return head;
    }
}