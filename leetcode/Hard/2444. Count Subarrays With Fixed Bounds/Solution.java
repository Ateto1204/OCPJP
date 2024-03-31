/**
 * https://leetcode.com/problems/count-subarrays-with-fixed-bounds
 * Problem ID: 2444. Count Subarrays With Fixed Bounds
 *
 * Author: Ateto
 */

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int p = -1;
        int q = -1;
        int dummy = -1;
        long result = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if((minK <= nums[i] && nums[i] <= maxK) == false) {
                dummy = i;
            }
            if(nums[i] == minK) {
                p = i;
            }
            if(nums[i] == maxK) {
                q = i;
            }
            int tmp = Integer.min(p, q) - dummy;
            tmp = Integer.max(0, tmp);
            result += tmp;
        }
        return result;
    }
}