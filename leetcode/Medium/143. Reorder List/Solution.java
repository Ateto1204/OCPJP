/*
 *
 * https://leetcode.com/problems/reorder-list
 * Problem ID: 143. Reorder List
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
    public void reorderList(ListNode head) {
        ListNode dummy = head;
        List<Integer> list = new ArrayList<>();
        while(dummy != null) {
            list.add(dummy.val);
            dummy = dummy.next;
        }
        int n = list.size();
        if(n <= 2) {
            return ;
        }
        dummy = head;
        for(int i = 0; i < n / 2; i++) {
            dummy.val = list.get(i);
            dummy = dummy.next;
            dummy.val = list.get(n - i - 1);
            dummy = dummy.next;
        }
        if(n % 2 == 1) {
            dummy.val = list.get(n / 2);
        }
    }
}