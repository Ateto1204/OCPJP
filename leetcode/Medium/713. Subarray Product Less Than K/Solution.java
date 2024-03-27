/**
 * https://leetcode.com/problems/subarray-product-less-than-k
 * Problem ID: 713. Subarray Product Less Than K
 *
 * Author: Ateto
 */

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int left = 0;
        int right = 0;
        int product = 1;
        int count = 0;
        int n = nums.length;
        while(right < n) {
            product *= nums[right];
            while(product >= k) {
                product /= nums[left];
                left++;
            }
            count += (right - left) + 1;
            right++;
        }
        return count;
    }
}