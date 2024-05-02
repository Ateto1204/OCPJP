/**
 * https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative
 * Problem ID: 2441. Largest Positive Integer That Exists With Its Negative
 *
 * Author: Ateto
 */

class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n-1; i >= 0; i--) {
            if (nums[i] < 0) break;
            for (int j = 0; j < n; j++) {
                if (nums[j] > 0) break;
                if (nums[i] > -nums[j]) break;
                if (nums[i] == -nums[j]) return nums[i];
            }
        }
        return -1;
    }
}