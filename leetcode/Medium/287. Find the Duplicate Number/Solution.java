/*
 *
 * https://leetcode.com/problems/find-the-duplicate-number
 * Problem ID: 287. Find the Duplicate Number
 *
 * Author: Ateto
 *
 */

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n+1];
        for(int i = 0; i < n; i++) {
            if(used[nums[i]]) {
                return nums[i];
            }
            used[nums[i]] = true;
        }
        return -1;
    }
}