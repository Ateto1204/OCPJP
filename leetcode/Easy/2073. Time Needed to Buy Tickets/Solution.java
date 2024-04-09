/**
 * https://leetcode.com/problems/time-needed-to-buy-tickets
 * Problem ID: 2073. Time Needed to Buy Tickets
 *
 * Author: Ateto
 */

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int target = tickets[k];
        if (target == 1) {
            return k + 1;
        }
        
        int sum = 0;
        int i = 0;
        boolean flag = true;
        for (int ticket : tickets) {
            if (i > k && flag) {
                flag = false;
                target--;
            }
            sum += Integer.min(target, ticket);
            i++;
        }
        return sum;
    }
}