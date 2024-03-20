/**
 * https://leetcode.com/problems/merge-in-between-linked-lists
 * Problem ID: 1669. Merge In Between Linked Lists
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode left = list1;
        for(int i = 0; i < a-1; i++) {
            left = left.next;
        }
        ListNode right = left.next;
        for(int i = 0; i <= b-a; i++) {
            right = right.next;
        }
        left.next = list2;
        while(left.next != null) {
            left = left.next;
        }
        left.next = right;
        return list1;
    }
}